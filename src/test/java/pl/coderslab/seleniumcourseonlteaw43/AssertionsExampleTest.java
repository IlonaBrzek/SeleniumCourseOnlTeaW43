package pl.coderslab.seleniumcourseonlteaw43;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsExampleTest {
    @Test
    public void assertionTest() {
        // given
        int a = 2;
        int b = 40;
        // when
        int actual = a + b;
        // then
        assertEquals(42, actual);
    }

    @Test
    public void moreAssertionsTest() {
        Assertions.assertTrue(true);
        assertFalse(false);
        assertEquals(2, 2);
        assertEquals(3.14, 3.14, "pi nie równa się pi");
        assertEquals("string", "string");
        Assertions.assertNotEquals("ala", "makota");
        assertNotNull(new Object());
        assertNull(null);
    }
}
