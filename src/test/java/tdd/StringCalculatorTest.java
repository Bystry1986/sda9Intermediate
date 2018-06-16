package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void shouldReturnZeroWhenDataIsEmpty() {
        //given
        String data = "";
        int expectedResult = 0;
        //when
        int actualResult = StringCalculator.adding(data);
        //then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnZeroWhenDataIsBlank() {
        //given
        String data = " ";
        int expectedResult = 0;
        //when
        int actualResult = StringCalculator.adding(data);
        //then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnNumberWhenDataIsSingleNumber() {
        //given
        String data1 = "1";
        String data2 = " 7 ";
        String data3 = " 0  ";
        int expectedResult1 = 1;
        int expectedResult2 = 7;
        int expectedResult3 = 0;
        //when
        int actualResult1 = StringCalculator.adding(data1);
        int actualResult2 = StringCalculator.adding(data2);
        int actualResult3 = StringCalculator.adding(data3);
        //then
        Assertions.assertEquals(expectedResult1, actualResult1);
        Assertions.assertEquals(expectedResult2, actualResult2);
        Assertions.assertEquals(expectedResult3, actualResult3);
    }

    @Test
    void ShouldThrowExceptionWhenLetter() {
        //given
        String data = "a";
        //when
        try {
            int actualResult = StringCalculator.adding(data);
            fail("Didn't throw");
        } catch (IllegalArgumentException exceptionA) {
            Assertions.assertEquals(IllegalArgumentException.class, exceptionA.getClass());
            Assertions.assertNotEquals(NumberFormatException.class, exceptionA.getClass());
        }
    }

    @Test
    void shouldReturnSumOfTwoDigitsSeparatedByComma() {
        //given
        String data = "1,2";
        int expectedResult = 3;
        //when
        int actualResult = StringCalculator.adding(data);
        //then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnSumForManyDigitsSeparatedWithCommaAndNewLines() {
        //given
        String data = "1 \n2,3";
        int expectedResult = 6;
        //when
        int actualResult = StringCalculator.adding(data);
        //then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnSumForManyDigitsSeparatedWithCustomDelimeter() {
        //given
        String data = "//****\n1****2****4****23";
        int expectedResult = 30;
        //when
        int actualResult = StringCalculator.adding(data);
        //then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldThrowExceptionWhenNegativeNumber() {
        //given
        String data = "-1";
        //when
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StringCalculator.adding(data));
        //then

    }
}