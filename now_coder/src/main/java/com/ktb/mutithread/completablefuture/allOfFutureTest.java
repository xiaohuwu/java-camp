package com.ktb.mutithread.completablefuture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class allOfFutureTest {
    public static void main(String[] args) {
        CompletableFuture<String> first = CompletableFuture.completedFuture("第一个异步任务");
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletableFuture<String> future = CompletableFuture
                //第二个异步任务
                .supplyAsync(() -> "第二个异步任务", executor)
                // (w, s) -> System.out.println(s) 是第三个任务
                .thenCombineAsync(first, (s, w) -> {
                    System.out.println(w);
                    System.out.println(s);
                    return "两个异步任务的组合";
                }, executor);
        System.out.println(future.join());
        executor.shutdown();

        Stream<Long> longStream = List.of("1", "2", "3").stream().map(Long::valueOf);
        LongStream ls = List.of("1", "2", "3").stream().mapToLong(Long::parseLong);


        try (Stream<String> lines = Files.lines(Paths.get("/Users/xioahuge/IdeaProjects/java-camp/now_coder/ReadMe.md"))) {
            lines.forEach(s -> System.out.println("s = " + s));
        } catch (IOException e) {
            e.printStackTrace();
        }


        List.of("  Apple ", " pear ", " ORANGE", " BaNaNa ").stream()
                .map(String::trim)
                .map(String::toLowerCase)
                .forEach(System.out::println);

        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter((item) -> item % 2 != 0).forEach((item) -> {
            System.out.println("item = " + item);
        });


        Stream.generate(new LocalDateSupplier()).limit(7)
                .filter(localDate -> localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(System.out::println);


        List<String> list = List.of("Apple", "Banana", "Orange");
        String[] array = list.stream().toArray(String[]::new);
        String s = Arrays.toString(array);
        System.out.println("s = " + s);


        Stream<String> stream = Stream.of("APPL:Apple", "MSFT:Microsoft");
        Map<Object, Object> collect = stream.collect(Collectors.toMap(s12 -> s12.split(":")[0], s1 -> s1.split(":")[1]));

        collect.forEach((key, value) -> {
            System.out.println("key = " + key);
            System.out.println("value = " + value);
        });
    }


}


class LocalDateSupplier implements Supplier<LocalDate> {
    LocalDate start = LocalDate.of(2020, 1, 1);
    int n = -1;

    public LocalDate get() {
        n++;
        return start.plusDays(n);
    }
}
