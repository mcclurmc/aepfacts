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
        if (query.contains("what is your name")) {
            return "Uakari Ninjas";
        }
        System.out.println("Request was: " + query);
        return "";
    }

}
