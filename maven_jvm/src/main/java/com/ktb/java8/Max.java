package com.ktb.java8;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Max {
    public static void main(String[] args) {
        System.out.println("---DoubleSummaryStatistics---");
        DoubleSummaryStatistics dstats = DoubleStream.of(5.33d,2.34d,5.32d,2.31d,3.51d).
                collect(DoubleSummaryStatistics::new, DoubleSummaryStatistics::accept,
                        DoubleSummaryStatistics::combine);
        System.out.println("Max:"+dstats.getMax()+", Min:"+dstats.getMin());
        System.out.println("Count:"+dstats.getCount()+", Sum:"+dstats.getSum());
        System.out.println("Average:"+dstats.getAverage());


    }
}
