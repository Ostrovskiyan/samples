package com.aostrovskyi.samples.tasks.codewars;

/***
 * Every book has n pages with page numbers 1 to n. The summary is made by adding up the number of digits of all page numbers.
 *
 * Task: Given the summary, find the number of pages n the book has.
 *
 * Example
 * If the input is summary=25, then the output must be n=17: The numbers 1 to 17 have 25 digits in total: 1234567891011121314151617.
 *
 * Be aware that you'll get enormous books having up to 100.000 pages.
 *
 * All inputs will be valid.
 */

public class HowManyPagesInABook {

    public static int amountOfPages2(int summary) {
        int amountOfPages = 0;

        int digitsNumber = 1;
        int prevBlockSummary = 0;
        int nextBlockSummary;

        do {
            int pagesInBlock = 9 * (int) Math.pow(10, digitsNumber - 1);
            int blockSummary = pagesInBlock * digitsNumber;
            nextBlockSummary = blockSummary + prevBlockSummary;

            if (summary >= nextBlockSummary) {
                amountOfPages += pagesInBlock;
            } else {
                amountOfPages += (summary - prevBlockSummary) / digitsNumber;
            }

            prevBlockSummary += blockSummary;
            digitsNumber++;
        } while (nextBlockSummary <= summary);

        return amountOfPages;
    }

    public static int amountOfPages3(int summary) {
        int amountOfPages = 0;
        int processedSummary = 0;
        int digitsNumber = 1;

        int pagesInBlock = 9;
        int nextBlockSummary;

        do {
            int currentBlockSummary =  pagesInBlock * digitsNumber;
            nextBlockSummary = currentBlockSummary + processedSummary;

            if (nextBlockSummary < summary) {
                amountOfPages += pagesInBlock;
                processedSummary += pagesInBlock * digitsNumber;

                pagesInBlock *= 10;
                digitsNumber++;
            } else {
                amountOfPages += (summary - processedSummary) / digitsNumber;
            }
        } while (nextBlockSummary < summary);

        return amountOfPages;
    }

    public static int amountOfPages(int summary) {
        int i = 1;
        for (int res = 0; res < summary; res += (int) (Math.log10(i) + 1), i++) {
        }
        return i - 1;
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(l);
        System.out.println(HowManyPagesInABook.amountOfPages(68888889));
        System.out.println(System.currentTimeMillis() - l);

        System.out.println("=====================================");

        l = System.currentTimeMillis();
        System.out.println(l);
        System.out.println(HowManyPagesInABook.amountOfPages2(68888889));
        System.out.println(System.currentTimeMillis() - l);

        System.out.println("=====================================");

        l = System.currentTimeMillis();
        System.out.println(l);
        System.out.println(HowManyPagesInABook.amountOfPages3(68888889));
        System.out.println(System.currentTimeMillis() - l);


        assertEquals(HowManyPagesInABook.amountOfPages(5), 5);
        assertEquals(HowManyPagesInABook.amountOfPages(25), 17);
        assertEquals(HowManyPagesInABook.amountOfPages(1095), 401);
        assertEquals(HowManyPagesInABook.amountOfPages(185), 97);
        assertEquals(HowManyPagesInABook.amountOfPages(660), 256);
    }

    private static void assertEquals(int amountOfPages, int i) {
        if (i == amountOfPages) {
            System.out.println("Test success");
        } else {
            System.out.println("Test error expected: " + i + " Actual: " + amountOfPages);
        }
    }
}
