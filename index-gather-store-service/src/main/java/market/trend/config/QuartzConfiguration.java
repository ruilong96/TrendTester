package market.trend.config;
 
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import market.trend.job.IndexDataSyncJob;
 
@Configuration
public class QuartzConfiguration {
    // update frequency: Interval 4 hrs
    private static final int interval = 1;

    // Create JobDetail
    @Bean
    public JobDetail indexDataSyncJobDetail() {
        return JobBuilder.newJob(IndexDataSyncJob.class).withIdentity("indexDataSyncJob")
        .storeDurably().build();
    }

    // Create trigger and execute JobDetail
    @Bean
    public Trigger indexDataSyncTrigger() {
        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInMinutes(interval).repeatForever();
         
        return TriggerBuilder.newTrigger().forJob(indexDataSyncJobDetail())
                .withIdentity("indexDataSyncTrigger").withSchedule(schedBuilder).build();
    }
}