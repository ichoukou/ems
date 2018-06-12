package com.channelsoft.ems.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * <dl>
 * <dt>BeanFactoryUtil</dt>
 * <dd>Description:bean加载对象</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2010-9-10</dd>
 * </dl>
 *
 * @author yuanshun
 */
public class BeanFactoryUtil implements ServletContextListener {
    private static Log logger = LogFactory.getLog(BeanFactoryUtil.class);
    private static ApplicationContext context;
    private static boolean isTestCode = false;
    private static ConfigurableListableBeanFactory factory;

    public void contextDestroyed(ServletContextEvent arg0) {

    }

    /**
     * 直接初始化BeanFactory
     *
     * @param context
     * @author 胡海波 2009-7-6
     */
    public static void setBeanFactory(ConfigurableListableBeanFactory context) {
        isTestCode = true;
        BeanFactoryUtil.factory = context;
    }

    /**
     * @param
     * @author wangjs
     */
    public void contextInitialized(ServletContextEvent event) {
        logger.info("初始化BeanFactory....");
        context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
        context = new ClassPathXmlApplicationContext("application-context.xml");

        logger.info("初始化BeanFactory....OK.");
        ConstantsMap.loadMap();
    }

    public static Object getBean(String beanName) {
        if (context == null && factory == null) {
            logger.warn("ApplicationContext 没有初始化！您无法获得业务处理对象，系统无法正常运行");
            logger.warn("context=" + context + "-----factory=" + factory);
            return null;
        }
        if (isTestCode) {
            return factory.getBean(beanName);
        }
        return context.getBean(beanName);
    }
}
