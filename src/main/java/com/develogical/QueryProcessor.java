package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.contains("hi")) {
            return "hello";
        }
        if (query.contains("name")) {
            return "Uakari Ninjas";
        }
        return "";
    }

}
