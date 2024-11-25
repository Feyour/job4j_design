package ru.job4j.generics;

public class Animal {
    private String kind;

    public Animal() {
    }

    public Animal(String name) {
        this.kind = name;
    }

    @Override
    public String toString() {
        return "Animal{"
                + "name='" + kind + '\''
                + '}';
    }
}
