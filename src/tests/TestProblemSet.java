package tests;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TestProblemSet{

    @Test
    public void testAverage(){
        ArrayList<Double> values = new ArrayList<>();
        values.add(10.0);
        values.add(20.0);
        values.add(30.0);

        assertEquals(20.0, ratings.ProblemSet.average(values), 0.1);
    }

    @Test
    public void testAverage2(){
        ArrayList<Double> values = new ArrayList<>();
        values.add(-5.0);
        values.add(5.0);

        assertEquals(0.0, ratings.ProblemSet.average(values), 0.1);
    }

    @Test
    public void testAverage3(){
        ArrayList<Double> values = new ArrayList<>();

        assertEquals(0.0, ratings.ProblemSet.average(values), 0.1);
    }

    @Test
    public void testAverage4(){
        ArrayList<Double> values = new ArrayList<>();
        values.add(5.0);
        values.add(100.0);
        values.add(45.0);
        values.add(50.0);
        values.add(25.0);
        values.add(60.0);
        values.add(65.0);

        assertEquals(50.0, ratings.ProblemSet.average(values), 0.1);
    }

    @Test
    public void testAverage5(){
        ArrayList<Double> values = new ArrayList<>();
        values.add(5.0);
        values.add(5.0);
        values.add(5.0);
        values.add(5.0);

        assertEquals(5.0, ratings.ProblemSet.average(values), 0.1);
    }

    @Test
    public void testAverage6(){
        ArrayList<Double> values = new ArrayList<>();
        values.add(4.0);

        assertEquals(4.0, ratings.ProblemSet.average(values), 0.1);
    }

    @Test
    public void testAverage7(){
        ArrayList<Double> values = new ArrayList<>();
        values.add(1000.0);
        values.add(2000.0);
        values.add(0.0);

        assertEquals(1000.0, ratings.ProblemSet.average(values), 0.1);
    }

    @Test
    public void testSumOfDigits(){
        assertEquals(6, ratings.ProblemSet.sumOfDigits(123));
        assertEquals(12, ratings.ProblemSet.sumOfDigits(57));
        assertEquals(0, ratings.ProblemSet.sumOfDigits(0));
        assertEquals(14, ratings.ProblemSet.sumOfDigits(455));
        assertEquals(24, ratings.ProblemSet.sumOfDigits(789));
    }

    @Test
    public void testSumOfDigits2(){
        assertEquals(12, ratings.ProblemSet.sumOfDigits(444));
        assertEquals(27, ratings.ProblemSet.sumOfDigits(999));
        assertEquals(11, ratings.ProblemSet.sumOfDigits(1424));
        assertEquals(36, ratings.ProblemSet.sumOfDigits(9999));
        assertEquals(15, ratings.ProblemSet.sumOfDigits(456));
    }

    @Test
    public void testSumOfDigits3(){
        assertEquals(1, ratings.ProblemSet.sumOfDigits(100));
        assertEquals(2, ratings.ProblemSet.sumOfDigits(200));
        assertEquals(5, ratings.ProblemSet.sumOfDigits(500));
        assertEquals(9, ratings.ProblemSet.sumOfDigits(9000));
        assertEquals(1, ratings.ProblemSet.sumOfDigits(1000000));
    }

    @Test
    public void testSumOfDigitsWithNegatives(){
        assertEquals(5, ratings.ProblemSet.sumOfDigits(-230));
        assertEquals(11, ratings.ProblemSet.sumOfDigits(-65));
        assertEquals(9, ratings.ProblemSet.sumOfDigits(-36));
        assertEquals(14, ratings.ProblemSet.sumOfDigits(-455));
        assertEquals(24, ratings.ProblemSet.sumOfDigits(-789));
    }

    @Test
    public void testBestKey(){
        HashMap<String, Integer> testHash1 = new HashMap<>();
        testHash1.put("CSE", 100);
        testHash1.put("MTH", 90);
        testHash1.put("MGT", 10);
        assertEquals("CSE", ratings.ProblemSet.bestKey(testHash1));
        HashMap<String, Integer> testHash2 = new HashMap<>();
        testHash2.put("Sauce Gardner", 1);
        testHash2.put("Aaron Rodgers", 8);
        testHash2.put("Garrett Wilson", 17);
        assertEquals("Garrett Wilson", ratings.ProblemSet.bestKey(testHash2));
        HashMap<String, Integer> testHash3 = new HashMap<>();
        assertEquals("", ratings.ProblemSet.bestKey(testHash3));
    }

    @Test
    public void testBestKey2(){
        HashMap<String, Integer> testHash1 = new HashMap<>();
        testHash1.put("CSE", 100);
        testHash1.put("MTH", 100);
        testHash1.put("MGT", 100);
        assertEquals("MGT", ratings.ProblemSet.bestKey(testHash1));
    }

    @Test
    public void testBestKey3(){
        HashMap<String, Integer> testHash1 = new HashMap<>();
        testHash1.put("CSE", 100);
        testHash1.put("MTH", 100);
        testHash1.put("MGT", 200);
        assertEquals("MGT", ratings.ProblemSet.bestKey(testHash1));
    }

    @Test
    public void testBestKeyWithNegatives(){
        HashMap<String, Integer> testHash4 = new HashMap<>();
        testHash4.put("Negative", -15);
        testHash4.put("NegativeAgain", -99);
        testHash4.put("NegativeThree", -3);
        assertEquals("NegativeThree", ratings.ProblemSet.bestKey(testHash4));
        HashMap<String, Integer> testHash5 = new HashMap<>();
        testHash5.put("Negative1", -16);
        testHash5.put("Negative2", -8);
        testHash5.put("Negative3", -21);
        assertEquals("Negative2", ratings.ProblemSet.bestKey(testHash5));
        HashMap<String, Integer> testHash6 = new HashMap<>();
        testHash6.put("Negative", -100);
        testHash6.put("NegativeDos", -101);
        testHash6.put("NegativeTres", -102);
        assertEquals("Negative", ratings.ProblemSet.bestKey(testHash6));
    }
}