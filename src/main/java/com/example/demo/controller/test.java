package com.example.demo.controller;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class test {
    public static void main(String[] args) {

        IntStream.iterate(5,i->i<10,i->i+1).forEach(System.out::println);

        IntSummaryStatistics  intSummaryStatistics = IntStream.iterate(0,i->i<=10,i->i+1).summaryStatistics();
        System.out.println(intSummaryStatistics);

    }
}
