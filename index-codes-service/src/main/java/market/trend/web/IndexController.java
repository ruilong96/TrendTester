package market.trend.web;
 
import java.util.List;
 
import market.trend.config.IpConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
import market.trend.tool.Index;
import market.trend.service.IndexService;
  
@RestController
public class IndexController {
    @Autowired IndexService indexService;
    @Autowired IpConfiguration ipConfiguration;
     
//  http://127.0.0.1:8011/codes
     
    @GetMapping("/codes")
    @CrossOrigin
    public List<Index> codes() throws Exception {
        System.out.println("current instance's port is "+ ipConfiguration.getPort());
        return indexService.get();
    }
}