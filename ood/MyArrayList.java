package ood;

import java.util.ArrayList;

public class MyArrayList<T> {
    T[] elements;


    public MyArrayList() {
        this.elements = (T[]) new Object[2];
        elements[0] = (T)Integer.valueOf(12);
        elements[1] = (T)"Hello";

    }

//    public static void main(String[] args) {
//        MyArrayList<String> a = new MyArrayList<>();
//        System.out.println("start");
//        Integer i = 12;
////        String s = (String) i;
////        System.out.println(a.elements[0]);
//        ArrayList<String> s = new ArrayList<>();
//    }
}
