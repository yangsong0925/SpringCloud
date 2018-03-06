/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: OrderService
 * Author:   Administrator
 * Date:     2018/3/6 14:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.syys.microservice.order.service;

import cn.syys.microservice.order.pojo.Item;
import cn.syys.microservice.order.pojo.Order;
import cn.syys.microservice.order.pojo.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2018/3/6
 * @since 1.0.0
 */
@Service
public class OrderService {

    public static final Map<String,Order> MAP = new HashMap<String,Order>();

    static {
        // 构造测试数据
        Order order = new Order();
        order.setOrderId("59193738268961441");
        order.setCreateDate(new Date());
        order.setUpdateDate(order.getCreateDate());
        order.setUserId(1L);
        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

        Item item = new Item();// 此处并没有商品的数据，需要调用商品微服务获取
        item.setId(1L);
        orderDetails.add(new OrderDetail(order.getOrderId(), item));

        item = new Item(); // 构造第二个商品数据
        item.setId(2L);
        orderDetails.add(new OrderDetail(order.getOrderId(), item));

        order.setOrderDetails(orderDetails);

        MAP.put(order.getOrderId(), order);
    }

    @Autowired
    private ItemService itemService;

    public Order queryOrderById(long orderId){
        Order order = MAP.get(String.valueOf(orderId));
        List<OrderDetail> details = order.getOrderDetails();
        for (OrderDetail detail : details){
            Item item = this.itemService.queryItemById(detail.getItem().getId());
            if (null == item)
                continue;
            detail.setItem(item);
        }
        return order;
    }

}