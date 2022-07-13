package StackCalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTests {

    @Test
    //сложение
    public void test1() {
        Calc c = new Calc();
        int result;
        result = c.compile("2+3+1".toCharArray());
        assertEquals(6, result);
        result = c.compile("2+3+4".toCharArray());
        assertEquals(9, result);
        result = c.compile("2+3+9".toCharArray());
        assertEquals(14, result);
    }

    @Test
    //вычитание
    public void test2() {
        Calc c = new Calc();
        int result;
        result = c.compile("3-1-1".toCharArray());
        assertEquals(1, result);
        result = c.compile("9-3-3".toCharArray());
        assertEquals(3, result);
        result = c.compile("5-8+4".toCharArray());
        assertEquals(1, result);
    }

    @Test
    // приоритет сложения перед умножением
    public void test3() {
        Calc c = new Calc();
        int result;
        result = c.compile("100+200*2".toCharArray());
        assertEquals(600, result);
        result = c.compile("15*2+3".toCharArray());
        assertEquals(75, result);
        result = c.compile("3+3*4+4".toCharArray());
        assertEquals(48, result);
    }

    @Test
    // приоритет вычитания перед делением
    public void test4() {
        Calc c = new Calc();
        int result;
        result = c.compile("8-2/2".toCharArray());
        assertEquals(3, result);
        result = c.compile("6/8-2".toCharArray());
        assertEquals(1, result);
        result = c.compile("5-1/2".toCharArray());
        assertEquals(2, result);
    }

    @Test
    // комбо
    public void test5() {
        Calc c = new Calc();
        int result;
        result = c.compile("800+200/500-300".toCharArray());
        assertEquals(5, result);
        result = c.compile("600/(20+10*20)".toCharArray());
        assertEquals(1, result);
    }
}
