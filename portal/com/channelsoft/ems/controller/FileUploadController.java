package com.channelsoft.ems.controller;

import java.io.File;
import java.io.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Administrator
 * 文件上传
 * 具体步骤：
 * 1）获得磁盘文件条目工厂 DiskFileItemFactory 要导包
 * 2） 利用 request 获取 真实路径 ，供临时文件存储，和 最终文件存储 ，这两个存储位置可不同，也可相同
 * 3）对 DiskFileItemFactory 对象设置一些 属性
 * 4）高水平的API文件上传处理  ServletFileUpload upload = new ServletFileUpload(factory);
 * 目的是调用 parseRequest（request）方法  获得 FileItem 集合list ，
 *
 * 5）在 FileItem 对象中 获取信息，   遍历， 判断 表单提交过来的信息 是否是 普通文本信息  另做处理
 * 6）
 *    第一种. 用第三方 提供的  item.write( new File(path,filename) );  直接写到磁盘上
 *    第二种. 手动处理
 *
 */
@Controller
@RequestMapping("/file")
public class FileUploadController{
    private Logger logger= Logger.getLogger(FileUploadController.class);

    @ResponseBody
    @RequestMapping("/upload")
    public String fileupload(@RequestParam("myfiles") MultipartFile fileField, @RequestParam("imgName")String imgName,
                             @RequestParam(value = "formFieldId", required = false, defaultValue = "pic_url") String formFieldId,
                             Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(currentTime);

        String curDateDir = dateString;// 当天日期,用于当天的目录名称

        String path=request.getRealPath("//picture");
        File file=new File(path);
        if(!file.exists()){
            file.mkdir();
            System.out.println(path);
        }

        StringBuffer picUrl = new StringBuffer(path);
        // 格式:  /picture/日期/文件名
        picUrl = picUrl.append("/").append(curDateDir).append("/");
        //picUrl.append("\\")
        // 可行后缀
        final String[] allowedExt = new String[] { "gif", "GIF",
                "jpg", "JPG", "swf", "SWF", "PNG", "png", "FLV",
                "flv", "FLA", "fla", "jpeg" };

        String fileName = "";
        try {

            // 得到文件的扩展名(无扩展名时将得到全名)
            String t_ext = fileField.getContentType().substring(
                    fileField.getContentType().lastIndexOf("/") + 1);
            System.out.println("文件后缀为:" + t_ext);

            // 判断后缀 是否 被允许
            boolean allowFlag = false;
            for ( String string : allowedExt ) {
                if ( string.equals(t_ext.toLowerCase()) ){
                    allowFlag = true;
                    break;
                }
            }

            System.out.println("aa");

            // 后缀不符
            if ( allowFlag == false ) {

                String message = "请上传以下类型的文件:";
                for ( String string : allowedExt ) {
                    message += " *." + string ;
                }
                message +=  "\n当前上传的文件格式为: " +t_ext;

                Map<String, String>map = new HashMap<String, String>();
                map.put("formFieldId", formFieldId);
                map.put("message", message);
                return JSONObject.toJSONString(map);
            }

            // 文件 1000K 大小限制
            if ( fileField.getSize() > 1000 * 1024 ) {

                Map<String, String>map = new HashMap<String, String>();
                map.put("formFieldId", formFieldId);
                map.put("message", "上传文件大小不被允许!");
                return JSONObject.toJSONString(map);
            }
            System.out.println("cc");

            // 文件名
            String name = fileField.getOriginalFilename();

            // 处理文件名
//            fileName = FileUtil.dealName(name);

            fileName=imgName+".jpg";
            System.out.println(imgName+"imgName");

            // 先上传到 web
            FileUtils.copyInputStreamToFile(fileField.getInputStream(), new File(picUrl.toString(), fileName));

            System.out.println(picUrl.toString() + fileName);

            // 生成图片地址
            picUrl.append(fileName);


        }
        catch (Exception e) {

            e.printStackTrace();
        }
        System.out.println("ff");
        Map<String, String> map = new HashMap<String, String>();
        map.put("formFieldId", formFieldId);
        map.put("fileUrl", picUrl.toString());
        map.put("message", "上传成功!");
        return JSONObject.toJSONString(map);
    }

}