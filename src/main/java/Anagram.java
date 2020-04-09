import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * From https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
 */
public class Anagram {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        Map<Character, Integer> ocurrencesA = getOcurrencesMap(a);
        Map<Character, Integer> ocurrencesB = getOcurrencesMap(b);

        Set<Character> uniqueChars = new HashSet<>();
        uniqueChars.addAll(ocurrencesA.keySet());
        uniqueChars.addAll(ocurrencesB.keySet());

        return uniqueChars.stream()
                .map(c ->  Math.abs(ocurrencesA.getOrDefault(c, 0) - ocurrencesB.getOrDefault(c, 0)))
                .reduce(0, (i,j) -> i + j);

    }

    static Map<Character, Integer> getOcurrencesMap(String a) {
        Map<Character, Integer> ocurrences = new HashMap<>();
        a.chars().forEach(c -> {
            Integer n = ocurrences.get((char)c);
            ocurrences.put((char)c, n == null ? 1 : n+1);
        });
        return ocurrences;
    }

}