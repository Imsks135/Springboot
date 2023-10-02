package com.cgi.fruits;

public class Summer implements Fruit {
    private String name;
    private boolean isSeasonal;

    public Summer(String name, boolean isSeasonal) {
        this.name = name;
        this.isSeasonal = isSeasonal;
    }

    public String getName() {
        return name;
    }

    public boolean isSeasonal() {
        return isSeasonal;
    }
}
