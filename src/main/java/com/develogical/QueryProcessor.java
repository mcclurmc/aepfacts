package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        String[] request = query.split(":");

        if (request.length == 1)
            return processQuery(request[0]);
        else
            return processQuery(request[1]);
    }

    private String processQuery(String query) {
        if (query.contains("hi")) {
            return "hello";
        }
        if (query.contains("what is your name")) {
            return "Uakari Ninjas";
        }
        System.out.println("Request was: " + query);
        return "";
    }

}
