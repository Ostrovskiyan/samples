package com.aotrosvskyi.samples.patterns.interpreter;

import com.aostrovskyi.samples.patterns.interpreter.ExpressionProcessor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressionProcessorTest {

    @Test
    public void testValues() {
        ExpressionProcessor ep = new ExpressionProcessor();

        assertEquals(6, ep.calculate("1+2+3"));
        assertEquals(0, ep.calculate("1+2+xy"));

        ep.variables.put('x', 3);
        assertEquals(5, ep.calculate("10-2-x"));
    }

}
