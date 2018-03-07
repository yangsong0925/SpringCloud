package cn.syys.microservice.order.service;

import cn.syys.microservice.order.OrderApplication;
import cn.syys.microservice.order.properties.OrderProerties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest
@Import(OrderApplication.class)
public class ItemServiceTest {

    @Autowired
	private LoadBalancerClient loadBalancerClient;
	@Autowired
	private OrderProerties orderProerties;
	
	@Test
	public void test(){
		String serviceId = orderProerties.getItem().getServiceId();
		for (int i = 0; i < 100; i++) {
			ServiceInstance serviceInstance = this.loadBalancerClient.choose(serviceId);
			System.out.println("第"+(i+1)+"次：" + serviceInstance.getHost() + ": " + serviceInstance.getPort());
		}
	}

}