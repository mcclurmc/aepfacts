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
        if (query.contains("plus")) {
            return processPlusQuery(query);
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

}
