package com.restaurant.model;


public class Reservation {
    private String name;
    private String date;
    private String time;
    private int people;

    public Reservation(String name, String date, String time, int people) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.people = people;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public int getPeople() { return people; }
    public void setPeople(int people) { this.people = people; }
}
