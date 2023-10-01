package pl.coderslab.seleniumcourseonlteaw43;

import org.junit.jupiter.api.*;

public class JunitFirstTest {

    @Test
    public void firstTest() {
        //given
        //when
        System.out.println("firstTest");
        //then
    }

    @Test
    public void secondTest() {
        System.out.println("secondTest");
    }

    @Disabled
    @Test
    public void thirdTest() {
        System.out.println("thirdTest");
    }

    @BeforeEach
    public  void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll");
    }
}
