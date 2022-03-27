package com.aostrovskyi.samples.tasks.codewars;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ProdFib {
    public static long[] productFib(long prod) {
        FibProds prods = new FibProds();

        for (FibProdResult res: prods) {
            if (res.getProd() >= prod) {
                return new long[] {res.getFactor1(), res.getFactor2(), res.getProd() == prod ? 1 : 0};
            }
        }

        return null;
    }

}

class FibProds implements Iterable<FibProdResult> {

    @Override
    public Iterator<FibProdResult> iterator() {
        return new FibProdIterator();
    }

    @Override
    public void forEach(Consumer<? super FibProdResult> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<FibProdResult> spliterator() {
        return Iterable.super.spliterator();
    }
}

class FibProdIterator implements Iterator<FibProdResult> {
    private FibProdResult result = null;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public FibProdResult next() {
        if (result == null) {
            result = new FibProdResult(0, 1, 0);
        } else {
            long nextFib = result.getFactor2() + result.getFactor1();
            result = new FibProdResult(
                    result.getFactor2(),
                    nextFib,
                    result.getFactor2() * nextFib
            );
        }
        return result;
    }
}

class FibProdResult {
    private final long factor1;
    private final long factor2;
    private final long prod;

    public FibProdResult(long factor1, long factor2, long prod) {
        this.factor1 = factor1;
        this.factor2 = factor2;
        this.prod = prod;
    }

    public long getFactor1() {
        return factor1;
    }

    public long getFactor2() {
        return factor2;
    }

    public long getProd() {
        return prod;
    }
}
