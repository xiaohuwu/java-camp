package com.shiyanlou;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    public  Optional<User> findById(@PathVariable Long id);

}
