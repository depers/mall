package cn.bravedawn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @author : depers
 * @program : junit
 * @description: Assertions example
 * @date : Created in 2021/12/8 22:00
 */
public class AssertionsTest {


    @Test
    void testAssertNotEquals() {
        Assertions.assertNotEquals(3, Calculator.add(2, 2));

        // Assertions.assertNotEquals(4, Calculator.add(2, 2), "Calculator.add(2, 2) test failed");

        Supplier<String> messageSupplier = () -> "Calculator.add(2, 2) test failed";
        Assertions.assertNotEquals(4, Calculator.add(2, 2), messageSupplier);
    }


    @Test
    void testAssertEquals() {
        Assertions.assertEquals(4, Calculator.add(2, 2));

        Assertions.assertEquals(3, Calculator.add(2, 2), "Calculator.add(2, 2) test failed");

        Supplier<String> messageSupplier = () -> "Calculator.add(2, 2) test failed";
        Assertions.assertEquals(3, Calculator.add(2, 2), messageSupplier);
    }


    @Test
    void testAssertArrayEquals() {
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3}, "Array Equal Test");

        Assertions.assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 3, 2}, "Array Equal Test");

        Assertions.assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3, 4}, "Array Equal Test");
    }


    @Test
    void testAssertIterableEquals() {
        Iterable<Integer> listOne = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Iterable<Integer> listTwo = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Iterable<Integer> listThree = new ArrayList<>(Arrays.asList(1, 2, 3));
        Iterable<Integer> listFour = new ArrayList<>(Arrays.asList(1, 2, 4, 3));


        Assertions.assertIterableEquals(listOne, listTwo, "Iterable Equal Test");

        Assertions.assertIterableEquals(listOne, listThree, "Iterable Equal Test");

        Assertions.assertIterableEquals(listOne, listFour, "Iterable Equal Test");
    }


    @Test
    void testAssertLinesMatch() {
        //Assertions.assertLinesMatch();
    }


    @Test
    void testAssertNullOrNotNull() {
        String nullString = null;
        String notNullString = "junit";

        Assertions.assertNotNull(notNullString);

        Assertions.assertNotNull(nullString);

        Assertions.assertNull(nullString);

        Assertions.assertNull(notNullString);
    }


    @Test
    void testAssertSameOrNotSame() {

    }


    @Test
    void testassertThrows() {
        Assertions.assertThrows()
    }

}
