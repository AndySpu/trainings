package quartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import persistence.BaseRepository;
import persistence.model.Master;

import javax.inject.Inject;
import java.util.List;

public class HelloJob implements Job {

    @Inject
    BaseRepository baseRepository;

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("Time: " + new java.util.Date() + "!");
        List<Master> allOrderedByName = baseRepository.findAllOrderedByName();
        allOrderedByName.stream().map(Master::getId).forEach(System.out::println);
    }
}

