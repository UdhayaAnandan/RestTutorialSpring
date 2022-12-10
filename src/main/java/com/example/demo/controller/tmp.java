package com.example.demo.controller;


import org.apache.coyote.http11.filters.IdentityOutputFilter;

class tmp1 {
    int mark;
}

public class tmp {
    public static void main(String[] args) {
//        tmp1 tmp11 = new tmp1();
//        System.out.println(tmp11.mark);

        int[] a = {1};
        tmp t = new tmp();
        t.increment(a);
        System.out.println(a[a.length-1]);
    }

    void increment(int[] i) {
        i[i.length-1]++;
    }
}
