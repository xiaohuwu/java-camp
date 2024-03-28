package com.mmall.concurrency.heima;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Sleeper {
    public Sleeper() {
    }

    public static void sleep(int i) {
        try {
            TimeUnit.SECONDS.sleep((long) i);
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        Duration d2 = Duration.parse("P1DT2H3M");
//        long l = d2.toDays();
//        long l1 = d2.toHours();
//        System.out.println("l1  = " + l1);
//        Period p = LocalDate.of(2020, 11, 19).until(LocalDate.of(2019, 1, 9));
//        Duration between = Duration.between(LocalDate.of(2020, 11, 19), LocalDate.of(2019, 1, 9));
//        long days = between.toDays();
//        System.out.println("days  = " + days);
//
//        long daysBetween = ChronoUnit.DAYS.between(LocalDate.of(2020, 11, 19), LocalDate.of(2019, 1, 9));
//        System.out.println("daysBetween = " + daysBetween);


//        long l = System.currentTimeMillis() / 1000;
//        Instant ins = Instant.ofEpochSecond(1711595796);
//        ZonedDateTime zdt = ins.atZone(ZoneId.systemDefault());
//        System.out.println(zdt);
//        Instant now = Instant.now();
//        System.out.println("now = " + now.getEpochSecond());



        long ts = Instant.now().getEpochSecond();
        System.out.println(timestampToString(ts, Locale.CHINA, "Asia/Shanghai"));
        System.out.println(timestampToString(ts, Locale.US, "America/New_York"));


        String[] split = "a b c".split("\\s");

        LocalDate start = LocalDate.of(2024,3,25);//开始时间
        LocalDate end = LocalDate.now();//当前时间
        Long cha = end.toEpochDay() - start.toEpochDay();//天数差
        System.out.println("cha = " + cha);
        long between = ChronoUnit.DAYS.between(end, start);

    }




    static String timestampToString(long epochMilli, Locale lo, String zoneId) {
        Instant ins = Instant.ofEpochSecond(epochMilli);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMMM-dd HH:mm", Locale.CHINA);
        return formatter.format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoneId)));
    }
}
