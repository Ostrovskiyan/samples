package com.aotrosvskyi.samples.tasks.codewars;

import com.aostrovskyi.samples.tasks.codewars.Solution;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void test() {
        assertEquals(23, new Solution().solution(10));
    }

}
