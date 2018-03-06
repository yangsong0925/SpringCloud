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
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderProerties orderProerties;
//    @Value("${ys.item.url}")
//    public String ysItemUrl;

    public Item queryItemById(Long itemId){
//        return this.restTemplate.getForObject(ysItemUrl+itemId,Item.class);
        return this.restTemplate.getForObject(orderProerties.getItem().getUrl()+itemId,Item.class);
    }

}