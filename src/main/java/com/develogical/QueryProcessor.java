package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        String[] request = query.split(":");

        if (request.length == 1)
            return processQuery(request[0], request);
        else
            return processQuery(request[1], request);
    }

    private String processQuery(String query, String[] request) {
        if (query.contains("which of the following numbers is the largest")) {
            return new LargestNumber().findLargestNumber(request[2]);
        }
        if (query.contains("what currency did Spain use before the Euro")) {
            return "peseta";
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
        if (query.contains("plus")) {
            return processPlusQuery(query);
        }
        if (query.contains("multiplied by")) {
            return processMultQuery(query);
        }
        System.out.println("Request was: " + query);
        return "";
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
