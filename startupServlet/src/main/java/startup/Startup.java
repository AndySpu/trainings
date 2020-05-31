package startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Startup extends HttpServlet {

    final Logger logger = LoggerFactory.getLogger(Startup.class);

    @Override
    public void init() throws ServletException {
        logger.info("===================== Startup servlet was started ============================");
    }
}
