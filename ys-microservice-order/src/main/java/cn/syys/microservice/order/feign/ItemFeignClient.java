package cn.syys.microservice.order.feign;

import cn.syys.microservice.order.pojo.Item;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Administrator on 2018/3/7.
 */
@FeignClient("ys-microservice-item")     // 申明这是一个Feign客户端，并且指明服务id
public interface ItemFeignClient {

    @GetMapping("/item/{id}")
    public Item queryItemById(@PathVariable("id")Long id);

}
