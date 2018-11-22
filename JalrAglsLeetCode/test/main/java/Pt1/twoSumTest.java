package main.java.Pt1;

import org.junit.Test;

import static Pt1.twoSum.answer_1;
import static org.junit.Assert.*;

public class twoSumTest {

    @Test
    public void twoSum() {
        int[] nums = { 2, 7, 11, 15};
        int target = 9;
        int[] result = answer_1(nums, target);
        for (int t : result
             ) {
            System.out.print(t+"    ");
        }
    }
}