package com.develogical;

import java.math.BigInteger;
import java.util.ArrayList;

import com.develogical.web.SquareCube;

public class QueryProcessor {

    public String process(String query) {
        String[] request = query.split(":");
        String result;

        if (request.length == 1)
            result = processQuery(request[0], request);
        else
            result = processQuery(request[1], request);

        System.out.println("Result of request " + request[0] + ": " + result);
        return result;
    }

    private String processQuery(String query, String[] request) {
        if (query.contains("which of the following numbers are primes")) {
            return new Primes().findPrime(request[2]);
        }
        if (query.contains("which of the following numbers is the largest")) {
                return new LargestNumber().findLargestNumber(request[2]);
        }
        if (query.contains("power")) {
            return processPowerQuery(query);
        }
        if (query.contains("what currency did Spain use before the Euro")) {
            return "peseta";
        }
        if (query.contains("number in the Fibonacci sequence")) {
            return new Fibs().findFib(query);
        }
        if (query.contains("which city is the Eiffel tower in")) {
            return "Paris";
        }
        if (query.contains("what colour is a banana")) {
            return "yellow";
        }
        if (query.contains("who is the Prime Minister of Great Britain")) {
            return "David Cameron";
        }
        if (query.contains("who played James Bond in the film Dr No"))
            return "Sean Connery";
        if (query.contains("what is your name")) {
            return "Uakari Ninjas";
        }
        if (query.contains("plus") && query.contains("multiplied by")) {
            if(query.indexOf("plus") > query.indexOf("multiplied by") )  {
                return processMultPlusQuery(query);

            }else{
                return processPlusMultQuery(query);

            }
        }
        if (query.contains("plus")) {
            return processPlusQuery(query);
        }
        if (query.contains("minus")) {
            return processMinusQuery(query);
        }
        if (query.contains("multiplied by")) {
            return processMultQuery(query);
        }
        if (query.contains("which of the following numbers is both a square and a cube")) {
            System.out.println("Square and cube: " + request[2]);
            return new SquareCube().isSquare(request[2]);
        }
        System.out.println("*** Unknown request was: " + query + " ***");
        return "";
    }

    private String processPlusMultQuery(String query) {
        String[] parts = query.split(" ");
        ArrayList<Integer> ints = getInts(parts);
        //System.out.println(ints.get(0).intValue() + " + (" + ints.get(1).intValue() + " * " + ints.get(2).intValue() + ")");
        int result = ints.get(0).intValue() + (ints.get(1).intValue() * ints.get(2).intValue());
        return String.valueOf(result);
    }

    private String processMultPlusQuery(String query) {
        String[] parts = query.split(" ");
        ArrayList<Integer> ints = getInts(parts);
        //System.out.println(ints.get(0).intValue() + " + (" + ints.get(1).intValue() + " * " + ints.get(2).intValue() + ")");
        int result = (ints.get(0).intValue() * ints.get(1).intValue()) + ints.get(2).intValue();
        return String.valueOf(result);
    }

    private ArrayList<Integer> getInts(String[] parts) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i<parts.length; i++) {
            try {
                Integer num = Integer.parseInt(parts[i].trim());
                nums.add(num);
            }
            catch (Exception e) {}
        }
        return nums;
    }

    private String processMinusQuery(String query) {
        String[] parts = query.split(" ");
        int flag = 1;
        int total = 0;
        Integer num = null;
        for (int i = 0; i<parts.length; i++) {
            try {
                num = Integer.parseInt(parts[i].trim());
                total = total + (flag * num.intValue());
                flag = -1;
            }
            catch (Exception e) {}
        }

        return String.valueOf(total);
    }

    private String processPowerQuery(String query) {
        String[] parts = query.split(" ");
        BigInteger a = null;
        int b = 1;
        Integer num = null;
        for (int i = 0; i<parts.length; i++) {
            try {
                num = Integer.parseInt(parts[i].trim());
                if(a == null){
                    a = BigInteger.valueOf(num.intValue());
                }else {
                    b = num.intValue();

                }
            }
            catch (Exception e) {}
        }
        return a.pow(b).toString();
    }

    private String processPlusQuery(String query) {
        String[] parts = query.split(" ");
        int total = 0;
        Integer num = null;
        for (int i = 0; i<parts.length; i++) {
            try {
                num = Integer.parseInt(parts[i].trim());
                total = total + num.intValue();
            }
            catch (Exception e) {}
        }

        return String.valueOf(total);
    }

    private String processMultQuery(String query) {
        String[] parts = query.split(" ");
        int total = 1;
        Integer num = null;
        for (int i = 0; i<parts.length; i++) {
            try {
                num = Integer.parseInt(parts[i].trim());
                total = total * num.intValue();
            }
            catch (Exception e) {}
        }

        return String.valueOf(total);
    }


}
