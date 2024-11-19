package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        int numberEdge = box.getNumberOfVertices();
        boolean isExist = box.isExist();
        double area = box.getArea();
        assertThat(name).isEqualTo("Sphere");
        assertThat(numberEdge).isLessThan(1);
        assertThat(isExist).isTrue();
        assertThat(area).isGreaterThan(55);
    }

    @Test
    void itThisTetrahedron() {
        Box box = new Box(4, 4);
        String name = box.whatsThis();
        int numberEdge = box.getNumberOfVertices();
        boolean isExist = box.isExist();
        double area = box.getArea();
        assertThat(name).isEqualTo("Tetrahedron");
        assertThat(numberEdge).isEqualTo(4);
        assertThat(isExist).isTrue();
        assertThat(area).isGreaterThan(0);
    }

    @Test
    void itThisCube() {
        Box box = new Box(8, 8);
        String name = box.whatsThis();
        int numberEdge = box.getNumberOfVertices();
        boolean isExist = box.isExist();
        double area = box.getArea();
        assertThat(name).isEqualTo("Cube");
        assertThat(numberEdge).isEqualTo(8);
        assertThat(isExist).isTrue();
        assertThat(area).isGreaterThan(10);
    }
}