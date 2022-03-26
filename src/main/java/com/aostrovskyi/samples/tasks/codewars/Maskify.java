package com.aostrovskyi.samples.tasks.codewars;

/**
 * Usually when you buy something, you're asked whether your credit card number, phone number or answer to your most secret question is still correct. However, since someone could look over your shoulder, you don't want that shown on your screen. Instead, we mask it.
 *
 * Your task is to write a function maskify, which changes all but the last four characters into '#'.
 */
public class Maskify {

    public static String maskify(String str) {
        if (str.length() <= 4) {
            return str;
        } else {
            return "#".repeat(str.length() - 4).concat(str.substring(str.length() - 4));
        }
    }

    public static void main(String[] args) {
        assertEquals("############5616", Maskify.maskify("4556364607935616"));
        assertEquals("#######5616",      Maskify.maskify(     "64607935616"));
        assertEquals("1",                Maskify.maskify(               "1"));
        assertEquals("",                 Maskify.maskify(                ""));

        // "What was the name of your first pet?"
        assertEquals("##ippy",                                    Maskify.maskify("Skippy")                                  );
        assertEquals("####################################man!",  Maskify.maskify("Nananananananananananananananana Batman!"));
    }

    private static void assertEquals(String s, String maskify) {
        if (s.equals(maskify)) {
            System.out.println("Test success");
        } else {
            System.out.println("Test error expected: " + s + " Actual: " + maskify);
        }
    }

}
