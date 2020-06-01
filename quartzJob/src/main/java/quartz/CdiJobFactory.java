package quartz;

import org.quartz.Job;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

@ApplicationScoped
public class CdiJobFactory implements JobFactory {

    @Inject
    BeanManager beanManager;

    @Override
    public Job newJob(TriggerFiredBundle triggerFiredBundle, Scheduler scheduler) throws SchedulerException {
        final Class<Job> jobClazz = (Class<Job>) triggerFiredBundle.getJobDetail().getJobClass();
        final Bean<Job> bean = (Bean<Job>) beanManager.getBeans(jobClazz).stream().findAny().orElseThrow(IllegalStateException::new);
        final CreationalContext<Job> ctx = beanManager.createCreationalContext(bean);

        return (Job) beanManager.getReference(bean, jobClazz, ctx);
    }
}
