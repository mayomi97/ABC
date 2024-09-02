package com.restaurant.model;



public class Query {
    private int id;
    private int userId;
    private String queryText;
    private String response;

    public Query(int id, int userId, String queryText, String response) {
        this.id = id;
        this.userId = userId;
        this.queryText = queryText;
        this.response = response;
    }

    public Query(int userId, String queryText) {
        this.userId = userId;
        this.queryText = queryText;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getQueryText() { return queryText; }
    public void setQueryText(String queryText) { this.queryText = queryText; }
    public String getResponse() { return response; }
    public void setResponse(String response) { this.response = response; }
}
