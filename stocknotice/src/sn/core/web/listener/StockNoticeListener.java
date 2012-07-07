package sn.core.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sn.core.task.MakeNoticeTask;
import sn.core.task.SendNoticeTask;

public class StockNoticeListener implements ServletContextListener {
    private static Log log = LogFactory.getLog(StockNoticeListener.class);

    private java.util.Timer makeNoticeTimer = null;
    private java.util.Timer sendNoticeTimer = null;

    public void contextDestroyed(ServletContextEvent sce) {
        log.info("停止生成通知任务、发送通知任务");

        if (null != makeNoticeTimer)
            makeNoticeTimer.cancel();

        if (null != sendNoticeTimer)
            sendNoticeTimer.cancel();
    }

    public void contextInitialized(ServletContextEvent sce) {
        log.info("启动生成通知任务、发送通知任务");

        if (null == makeNoticeTimer)
            makeNoticeTimer = new java.util.Timer(true);

        if (null == sendNoticeTimer)
            sendNoticeTimer = new java.util.Timer(true);

        makeNoticeTimer.schedule(new MakeNoticeTask(), 0, 10000);
        sendNoticeTimer.schedule(new SendNoticeTask(), 5000, 10000);
    }

}
