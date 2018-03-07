/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ItemApplication
 * Author:   Administrator
 * Date:     2018/3/6 14:02
 * Description: Item Spring Boot 入口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.syys.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Item Spring Boot 入口〉
 *
 * @author Administrator
 * @create 2018/3/6
 * @since 1.0.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ItemApplication {

    public static void main(String[] args){
        SpringApplication.run(ItemApplication.class,args);
    }

}