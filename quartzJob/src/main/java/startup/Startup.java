package startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quartz.QuartzBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Startup extends HttpServlet {

    final Logger logger = LoggerFactory.getLogger(Startup.class);

    @Inject
    private QuartzBean quartzBean;

    @Override
    public void init() throws ServletException {
        logger.info("===================== Startup servlet was started ============================");

        quartzBean.startTimer();
    }
}
