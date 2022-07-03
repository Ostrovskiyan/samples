package com.aotrosvskyi.samples.patterns.strategy;

import com.aostrovskyi.samples.patterns.strategy.Complex;
import com.aostrovskyi.samples.patterns.strategy.OrdinaryDiscriminantStrategy;
import com.aostrovskyi.samples.patterns.strategy.QuadraticEquationSolver;
import com.aostrovskyi.samples.patterns.strategy.RealDiscriminantStrategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuadraticEquationSolverTest {

    @Test
    public void testCommonQuadraticEquationWithRealsOnly() {
        QuadraticEquationSolver solver = new QuadraticEquationSolver(
                new RealDiscriminantStrategy());

        var res = solver.solve(1 , 7, 10);

        assertEquals(new Complex(-2, 0), res.first);
        assertEquals(new Complex(-5, 0), res.second);
    }

    @Test
    public void testQuadraticEquationWithNegativeDiscriminantRealsOnly() {
        QuadraticEquationSolver solver = new QuadraticEquationSolver(
                new RealDiscriminantStrategy());

        var res = solver.solve(1 , 1, 100);

        assertTrue(Double.isNaN(res.first.re()));
        assertTrue(Double.isNaN(res.second.re()));
    }

    @Test
    public void testCommonQuadraticEquationOrdinary() {
        QuadraticEquationSolver solver = new QuadraticEquationSolver(
                new OrdinaryDiscriminantStrategy());

        var res = solver.solve(1 , 7, 10);

        assertEquals(new Complex(-2, 0), res.first);
        assertEquals(new Complex(-5, 0), res.second);
    }

    @Test
    public void testCommonQuadraticEquationWithNegativeDiscriminantOrdinary() {
        QuadraticEquationSolver solver = new QuadraticEquationSolver(
                new OrdinaryDiscriminantStrategy());

        var res = solver.solve(1 , 2, 2);

        assertEquals(new Complex(-1, 1), res.first);
        assertEquals(new Complex(-1, -1), res.second);
    }

}
