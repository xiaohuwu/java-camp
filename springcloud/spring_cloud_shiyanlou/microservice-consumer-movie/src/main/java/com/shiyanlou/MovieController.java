package com.shiyanlou;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Optional;
//关闭 microservice-provider-user 服务 再次测试
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Value("${timeout:1}")
    String timeout;


    @Value("${key1:66}")
    String key1;
//    @Autowired
//    RestTemplate restTemplate;

    @Autowired
    UserFeignClient userFeignClient;


    @GetMapping("/configs")
    public String getConfig() {
        return "res: timeout:"+ timeout+" key:"+key1 ;
    }


    @GetMapping("/users/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public Optional<User> findById(@PathVariable Long id) {
//        User user=this.restTemplate.getForObject("http://microservice-provider-user"+"/users/{id}",User.class,id);
        Optional<User> user = userFeignClient.findById(id);
        return user;
    }


    public Optional<User> findByIdFallback(Long id) {
        User user = new User(id, "default username", "default name", 0, new BigDecimal(1));
        return Optional.of(user);
    }






}
