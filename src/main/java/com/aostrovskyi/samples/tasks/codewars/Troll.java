package com.aostrovskyi.samples.tasks.codewars;

import java.util.HashSet;
import java.util.Set;

public class Troll {

    private static final Set<Character> VOWELS = new HashSet<>();

    static {
        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
    }

    public static String disemvowel(String str) {
        final StringBuilder sb = new StringBuilder();
        for (char c: str.toCharArray()) {
            if (!isVowel(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static boolean isVowel(char c) {
        return VOWELS.contains(Character.toLowerCase(c));
    }

    public static void main(String[] args) {
        assertEquals("Ths wbst s fr lsrs LL!",Troll.disemvowel("This website is for losers LOL!")
        );
        assertEquals("N ffns bt,\nYr wrtng s mng th wrst 'v vr rd", Troll.disemvowel(
                "No offense but,\nYour writing is among the worst I've ever read"));
        assertEquals( "Wht r y,  cmmnst?", Troll.disemvowel("What are you, a communist?"));
    }

    private static void assertEquals(String s, String disemvowel) {
        if (s.equals(disemvowel)) {
            System.out.println("Test success");
        } else {
            System.out.println("Test error expected: " + s + " Actual: " + disemvowel);
        }
    }

}
