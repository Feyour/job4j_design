package ru.job4j.generics;

public class Predator extends Animal {
    final String predatorType;

    public Predator(String kind, String predatorType) {
        super(kind);
        this.predatorType = predatorType;
    }

    @Override
    public String toString() {
        return "Predator{"
                + "kind='" + super.toString() + '\''
                + ", predatorType='" + predatorType + '\''
                + '}';
    }
}
