package market.trend.web;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
import market.trend.tool.Index;
import market.trend.service.IndexService;
  
@RestController
public class IndexController {
    @Autowired IndexService indexService;
 
    @GetMapping("/getCodes")
    public List<Index> get() throws Exception {
        return indexService.fetch_indexes_from_third_part();
    }
}