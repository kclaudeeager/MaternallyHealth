package com.DU.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class simpleTest {
    calc cal = new calc();

    @Test
    void test1() {
        // given
        int a = 30;
        int b = 20;
        // when
        int result = cal.add(a, b);
        int expected = 50;

        // assertThat(result).isEqualTo(expected);
        assertEquals(expected, result, "addition done");
    }

    public class calc {

        public int add(int a, int b) {
            return a + b;
        }

    }

}
