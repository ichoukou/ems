package com.channelsoft.ems.controller;

import com.alibaba.fastjson.JSONObject;
import com.channelsoft.ems.po.AjaxResultPo;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxin on 2017/1/13.
 */

@Controller
@RequestMapping("/files")
public class NewFileController {
    private Logger logger= Logger.getLogger(FileUploadController.class);

    @ResponseBody
    @RequestMapping("/upload")
    public AjaxResultPo fileupload(@RequestParam("myfiles") MultipartFile fileField, @RequestParam("imgName")String imgName,
                                   @RequestParam(value = "formFieldId", required = false, defaultValue = "pic_url") String formFieldId,
                                   Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(currentTime);

        String curDateDir = dateString;// 当天日期,用于当天的目录名称

        String path=request.getRealPath("//img");
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
//        final String[] allowedExt = new String[] { "gif", "GIF",
//                "jpg", "JPG", "swf", "SWF", "PNG", "png", "FLV",
//                "flv", "FLA", "fla", "jpeg" };
        String fileName = "";
        try {
//            // 得到文件的扩展名(无扩展名时将得到全名)
//            String t_ext = fileField.getContentType().substring(
//                    fileField.getContentType().lastIndexOf("/") + 1);
//            // 判断后缀 是否 被允许
//            boolean allowFlag = false;
//            for ( String string : allowedExt ) {
//                if ( string.equals(t_ext.toLowerCase()) ){
//                    allowFlag = true;
//                    break;
//                }
//            }
//            // 后缀不符
//            if ( allowFlag == false ) {
//
//                String message = "请上传以下类型的文件:";
//                for ( String string : allowedExt ) {
//                    message += " *." + string ;
//                }
//                message +=  "\n当前上传的文件格式为: " +t_ext;
//
//                Map<String, String>map = new HashMap<String, String>();
//                map.put("formFieldId", formFieldId);
//                map.put("message", message);
//                return new AjaxResultPo(false,"");
//            }
//
//            // 文件 1000K 大小限制
//            if ( fileField.getSize() > 1000 * 1024 ) {
//
//                Map<String, String>map = new HashMap<String, String>();
//                map.put("formFieldId", formFieldId);
//                map.put("message", "上传文件大小不被允许!");
//                return new AjaxResultPo(false,"上传文件大小不被允许!");
//            }
            // 文件名
           // String name = fileField.getOriginalFilename();
            fileName=imgName+".jpg";
            // 先上传到 web
            FileUtils.copyInputStreamToFile(fileField.getInputStream(), new File(picUrl.toString(), fileName));
            // 生成图片地址
            picUrl.append(fileName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("formFieldId", formFieldId);
        map.put("fileUrl", picUrl.toString());
        map.put("message", "上传成功!");
        return new AjaxResultPo(true,map);
    }
}