package Task2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;


public class Task_2_TEST {

    private List<Integer> list(int... factors){
        List<Integer> listOfFactors = new ArrayList<>();

        for(int i : factors){
            listOfFactors.add(i);
        }
        return listOfFactors;
    }

    @Test
    public void testOne() {
        assertEquals(list(), Factorization.factor(1));
    }

    @Test
    public void testTwo() {
        assertEquals(list(2), Factorization.factor(2));
    }

    @Test
    public void testThree() {
        assertEquals(list(3), Factorization.factor(3));
    }

    @Test
    public void testFour() {
        assertEquals(list(2,2), Factorization.factor(4));
    }

    @Test
    public void testSeventyTwo() {
        assertEquals(list(2,2,2,3,3), Factorization.factor(72));
    }
}