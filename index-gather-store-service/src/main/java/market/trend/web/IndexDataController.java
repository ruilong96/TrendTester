package market.trend.web;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
 
import market.trend.tool.IndexData;
import market.trend.service.IndexDataService;
  
@RestController
public class IndexDataController {
    @Autowired IndexDataService indexDataService;
     
    @GetMapping("/freshIndexData/{code}")
    public String fresh(@PathVariable("code") String code) throws Exception {
        indexDataService.refresh(code);
        return "fresh index data successfully";
    }
    @GetMapping("/getIndexData/{code}")
    public List<IndexData> get(@PathVariable("code") String code) throws Exception {
        return indexDataService.get(code);
    }
    @GetMapping("/removeIndexData/{code}")
    public String remove(@PathVariable("code") String code) throws Exception {
        indexDataService.remove(code);
        return "remove index data successfully";
    }
}