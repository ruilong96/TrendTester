package market.trend.service;
 
import java.util.List;
 
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
 
import market.trend.tool.Index;
import cn.hutool.core.collection.CollUtil;
 
@Service
@CacheConfig(cacheNames="indexes")
public class IndexService {
    private List<Index> indexes;
 
    @Cacheable(key="'all_codes'")
    public List<Index> get(){
        Index index = new Index();
        index.setName("invalid index code");
        index.setCode("000000");
        return CollUtil.toList(index);
    }
}