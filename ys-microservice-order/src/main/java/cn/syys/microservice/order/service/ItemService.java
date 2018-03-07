/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ItemService
 * Author:   Administrator
 * Date:     2018/3/6 14:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.syys.microservice.order.service;

import cn.syys.microservice.order.pojo.Item;
import cn.syys.microservice.order.properties.OrderProerties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2018/3/6
 * @since 1.0.0
 */
@Service
public class ItemService {

    @Autowired  // Spring框架对RESTful方式的http请求做了封装，来简化操作
    private RestTemplate restTemplate;
    @Autowired
    private OrderProerties orderProerties;
    @Value("${ys.item.url}")
    private String ysItemUrl;
    @Autowired
    private DiscoveryClient discoveryClient;

    public Item queryItemById(Long itemId){
//        return this.restTemplate.getForObject(ysItemUrl+itemId,Item.class);
//        return this.restTemplate.getForObject(orderProerties.getItem().getUrl()+itemId,Item.class);
        String serviceId = orderProerties.getItem().getServiceId();
        List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);
        if(instances.isEmpty())
            return null;
        ServiceInstance serviceInstance = instances.get(0);
        String url = serviceInstance.getHost()+":"+serviceInstance.getPort();
        return restTemplate.getForObject("http://" + url + "/item/" +itemId,Item.class);
    }

}