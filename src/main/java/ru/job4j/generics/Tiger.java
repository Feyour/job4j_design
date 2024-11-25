package ru.job4j.generics;

public class Tiger extends Predator {
    final String name;

    public Tiger(String kind, String predatorType, String name) {
        super(kind, predatorType);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tiger{"
                + "kind='" + super.toString() + '\''
                + ", tigerName='" + name + '\''
                + '}';
    }
}
