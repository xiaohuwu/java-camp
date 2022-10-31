package com.ktb.java;

import com.ktb.model.UserInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LambdaTest2 {
    @Test
    public void test1() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo(1L, "捡田螺的小男孩", 18));
        userInfoList.add(new UserInfo(2L, "程序员田螺", 27));
        userInfoList.add(new UserInfo(2L, "捡瓶子的小男孩", 26));

        Map<Long, UserInfo> collect = userInfoList.stream().collect(Collectors.toMap(UserInfo::getId, userInfo -> userInfo, (k1, k2) -> k1));
        collect.forEach((k, v) -> System.out.println("k:" + k + "v:" + v));
    }
}
