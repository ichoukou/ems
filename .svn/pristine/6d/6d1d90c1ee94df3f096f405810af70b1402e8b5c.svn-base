package com.channelsoft.ems.common;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;

import com.channelsoft.ems.po.MailPo;


/** 
 * @author  郭金
 * @date 创建时间：2016年8月8日 上午11:51:51 
 * @parameter  
 * @return  
 */
public class MailUtil {
	private static Logger logger = Logger.getLogger(MailUtil.class);
	
	
	private static MailPo mail = new MailPo();
	
	static {  
        mail.setHost("smtp.channelsoft.com"); // 设置邮件服务器,如果不用163的,自己找找看相关的  
        mail.setSender("zhangchenhe@channelsoft.com");  
        mail.setReceiver(Config.getString(Config.DATAPUSH_RECEIVER)); // 接收人  
        mail.setUsername("zhangchenhe@channelsoft.com"); // 登录账号,一般都是和邮箱名一样吧  
        mail.setPassword("Zch3092151.8"); // 发件人邮箱的登录密码  
    }  
	
	public static boolean send(String entId) {  
		mail.setSubject(entId+"企业接口调用失败...请速调整");
		mail.setMessage("如题");
		
        // 发送email  
        HtmlEmail email = new HtmlEmail();  
        try {  
            // 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"  
            email.setHostName(mail.getHost());  
            // 字符编码集的设置  
            email.setCharset(MailPo.ENCODEING);  
            // 收件人的邮箱  
            email.addTo(mail.getReceiver());  
            // 发送人的邮箱  
            email.setFrom(mail.getSender(), mail.getName());  
            // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码  
            email.setAuthentication(mail.getUsername(), mail.getPassword());  
            // 要发送的邮件主题  
            email.setSubject(mail.getSubject());  
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签  
            email.setMsg(mail.getMessage());  
            // 发送  
            email.send();  
            if (logger.isDebugEnabled()) {  
                logger.debug(mail.getSender() + " 发送邮件到 " + mail.getReceiver());  
            }  
            return true;  
        } catch (EmailException e) {  
            e.printStackTrace();  
            logger.info(mail.getSender() + " 发送邮件到 " + mail.getReceiver()  
                    + " 失败");  
            return false;  
        }  
    }
	
	
  
}
