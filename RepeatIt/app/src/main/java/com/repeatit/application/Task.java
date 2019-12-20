package com.repeatit.application;

public class Task {

    private String name;
    private String link;
    private int frequency;
    private boolean completed;


    public Task(String name, String link, int frequency, boolean completed) {
        this.name = name;
        this.link = link;
        this.frequency = frequency;
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }




}
