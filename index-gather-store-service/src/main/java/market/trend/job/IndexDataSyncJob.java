package market.trend.job;
 
import java.util.List;

import market.trend.tool.Index;
import market.trend.service.IndexDataService;
import market.trend.service.IndexService;

import cn.hutool.core.date.DateUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
 
public class IndexDataSyncJob extends QuartzJobBean {
     
    @Autowired
    private IndexService indexService;
 
    @Autowired
    private IndexDataService indexDataService;
     
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Scheduled start：" + DateUtil.now());
        List<Index> indexes = indexService.refresh();
        for (Index index : indexes) {
             indexDataService.refresh(index.getCode());
        }
        System.out.println("Scheduled End：" + DateUtil.now());
 
    }
 
}