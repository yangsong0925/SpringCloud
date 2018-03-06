/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: OrderController
 * Author:   Administrator
 * Date:     2018/3/6 14:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.syys.microservice.order.controller;

import cn.syys.microservice.order.pojo.Order;
import cn.syys.microservice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2018/3/6
 * @since 1.0.0
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("order/{orderId}")
    public Order queryOrderById(@PathVariable("orderId")long orderId){
        return this.orderService.queryOrderById(orderId);
    }

}