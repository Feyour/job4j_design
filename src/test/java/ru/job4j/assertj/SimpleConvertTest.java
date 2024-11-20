package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("one", "two", "three", "four", "five");
        assertThat(list).hasSize(5)
                .contains("two", "five")
                .startsWith("one")
                .allSatisfy(e -> {
                    assertThat(e.length()).isGreaterThan(1);
                    assertThat(e.length()).isLessThan(10);
                })
                .containsAnyOf("one", "java", "Alber");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("one", "two", "three", "four", "five");
        assertThat(set).isNotEmpty()
                .containsExactlyInAnyOrder("four", "one", "five", "two", "three")
                .anyMatch(e -> e.length() > 3)
                .containsSequence("two", "three")
                .contains("four");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("one", "two", "three", "four", "five");
        assertThat(map).hasSize(5)
                .containsKeys("one")
                .containsValues(1, 0)
                .doesNotContainKey("java")
                .doesNotContainValue(12)
                .containsEntry("one", 0);

    }
}