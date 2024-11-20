package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");

    }

    @Test
    void  checkMessage() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("Job4j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain the symbol '='");

    }

    @Test
    void checkMessageThrow() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("=Job4j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a key");
    }

}