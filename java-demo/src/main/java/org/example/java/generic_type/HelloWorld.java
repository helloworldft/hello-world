package org.example.java.generic_type;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by heqingfu on 2020/8/25.
 */
public class HelloWorld {

    public static  void playFruit(List< ? extends Fruit> list){
        //do somthing
        //list.add(new Apple());

    }
    public  static  void playFruitBase(List < ? super  Fruit> list){
        Object obj=list.get(0);
        list.add(new Apple());
    }

    public static void main(String[] args) {
//        List<Apple> apples=new ArrayList<>();
//        List<Food> foods =new ArrayList<>();
//        List<Object> objects=new ArrayList<>();
//        objects.add(new Apple());
//        //playFruitBase(foods);
//        playFruitBase(objects);
//
//        //Pair<String> [] table = new Pair<String> [10];
//        //List<Pair<String>> table2 =  new ArrayList<Pair<String>>();
//
//        Pair<String> [] table = (Pair<String> [])new Pair<?> [10];
//        Object [] objArry = table;
//        objArry[0] = "hello";
//        objArry[1] = new Pair<Apple>();
//
//        Pair<String> p = (Pair<String>) apples;
//
//
////        if (apples instanceof List<Apple>) {
////
////        }
//
//        Dictionary<Integer, Component> labelTable = new Hashtable<>();
//        labelTable.put(0, new JLabel(new ImageIcon("nine.gif")));
//        JSlider jSlider = new JSlider();
//        jSlider.setLabelTable(labelTable);
//
//        Dictionary<Integer, Component> labelTable2 = jSlider.getLabelTable();
//
//        Pair<String> a = new Pair<>();
//
//        Pair<String> q = (Pair<String>) a;


//        HashSet<?> set1 = new HashSet<>();
//        HashSet<Integer> set2 = new HashSet();
//
//        set1.add(null);
//
//
//        System.out.println(numElementsInCommon(set1,set2));

        //List<String> [] stringLists = new List<String>[1];

//        List<? extends Integer> testList = new ArrayList<>();
//        testList.add(new Integer(1234));

//        List<?> [] stringLists = new List<?>[2];
//
//        List<Integer> intList = Arrays.asList(41);
//        List<String> stringList = Arrays.asList("42");
//        stringLists[0] = intList;
//        stringLists[1] = stringList;
//
//        for (List<?> list : stringLists) {
//            list.add(42);
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i));
//            }
//        }

//        Set<Integer> integers = new HashSet<Integer>();
//        integers.add(1);
//        Set<Double> doubles = new HashSet<Double>();
//        doubles.add(2.0);
//
//        Set<Number> numbers = HelloWorld.<Number>union(integers, doubles);
//
//        for (Number number : numbers) {
//            System.out.println(number);
//        }
        Favorites f = new Favorites();
        Object obj = new String("1234");
        f.putFavorite(Object.class, 1234);
    }

    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        
        for (Object o1 : s1) {
            if(s2.contains(o1)) {
                result++;
            }

        }
        return result;

    }

    static <E> E reduce(List<E> list, Function<E> f, E initVal) {
        E[] snapshot = (E[])list.toArray();
        E result = initVal;
        for (E e: snapshot) {
            result = f.apply(result, e);
        }
        return result;
    }

    interface Function<T> {
        T apply(T arg1, T arg2);
    }

    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {

        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        Iterator<? extends T> i = list.iterator();
        T result = i.next();
        while(i.hasNext()) {
            T t = i.next();
            if(t.compareTo(result) > 0) {
                result = t;
            }
        }
        return result;
    }

    public static class Favorites {
        private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();

        public <T> void putFavorite(Class<T> type, T instance) {
            if(type == null) {
                throw new NullPointerException("Type is null");
            }
            favorites.put(type, instance);
        }

        public <T> T getFavorite(Class<T> type) {
            return type.cast(favorites.get(type));
        }
    }
}
