package quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quartz.jobs.HelloJob;

import java.io.Serializable;
import java.util.Calendar;

import static org.quartz.JobBuilder.newJob;

public class QuartzBean implements Serializable {

    final Logger logger = LoggerFactory.getLogger(QuartzBean.class);

    public void startTimer() {
        logger.info("Starting the timer.");

        Trigger trigger = getTrigger();
        JobDetail job1 = getJob();

        startJob(trigger, job1);
    }

    private void startJob(Trigger trigger, JobDetail job1) {
        try {
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            scheduler.start();

            scheduler.scheduleJob(job1, trigger);

            logger.info("Timer started");
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    private JobDetail getJob() {
        return newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .build();
    }

    private Trigger getTrigger() {
        Calendar now = Calendar.getInstance();

        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);

        logger.info("Current time {}:{}:{}", hour, minute, second);

        return TriggerBuilder.newTrigger()
                .withIdentity("Trigger", "QuartzBean")
                .startAt(DateBuilder.todayAt(hour, minute + 1, 0))
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                .build();
    }

}
