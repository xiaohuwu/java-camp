package com.ktb.xuefeng.ioc;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.time.ZoneId;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
@Slf4j
@PropertySource("classpath:app.properties")
public class AppConfig {

//    @Value("${app.zone:Z}")
//    String zoneId;



    @Bean
    @Profile("!test")
    ZoneId createZoneId() {
        return ZoneId.systemDefault();
    }

    @Bean
    @Profile("test")
    ZoneId createZoneId(@Value("${app.zone:Z}") String zoneId) {
        return ZoneId.of(zoneId);
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = context.getBean(AppConfig.class);
//        String zoneId = bean.zoneId;
//        System.out.println("zoneId = " + zoneId);
        ZoneId createZoneId = (ZoneId) context.getBean(ZoneId.class);
        System.out.println("createZoneId = " + createZoneId);
//        MailService bean1 = context.getBean(MailService.class);
//        int smtpPort = bean1.getSmtpPort();
//        System.out.println("smtpPort = " + smtpPort);
//        String smtpHost = bean1.getSmtpHost();
//        System.out.println("smtpHost = " + smtpHost);




//        UserService userService = context.getBean(UserService.class);
//        User user = userService.login("bob@example.com", "password");
//        System.out.println(user.getName());
//
//        Resource resource = userService.resource;
//        try (BufferedReader reader = new BufferedReader(
//                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
//            String collect = reader.lines().collect(Collectors.joining("\n"));
//            System.out.println("collect = " + collect);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
