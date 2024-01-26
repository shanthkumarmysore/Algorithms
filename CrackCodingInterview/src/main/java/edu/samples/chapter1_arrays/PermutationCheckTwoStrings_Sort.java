package edu.samples.chapter1_arrays;

import java.util.Arrays;

/* Given two strings. Write a method to decide if one is a permutation of the other. Observe that strings of
different length cannot be  permutations of each other

If two strings are permutations, then we know they have the same characters,but in different orders.

 */
public class PermutationCheckTwoStrings_Sort {


    public static void main(String[] args) {
        System.out.println("Does Dog and God are permutation string =>" + permutation("dog","god"));
        System.out.println("Does Dog and Mad are permutation string =>" + permutation("dog","mad"));
    }

    static boolean permutation(String s , String t){
        if (s.length() != t.length() ) return false; // permutations must me same length

        return sort(s).equals(sort(t));
    }

    static String sort(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    /*
     Here we create an array that acts like a hashtable, mapping each character to its frequency.
     We increment through the first string and decrement through the second string. If the strings
     are permutations ,then the array will be all zeroes at the end.
     */
    static boolean permutation_solution2(String s, String t){

      if(s.length() != t.length()) return false; // permutations must be of same length

        int[] letters = new int[128]; // Assumption:ASCII

        for(int i=0; i < s.length(); i++){
            letters[s.charAt(i)]++;
        }

        for(int i = 0; i < t.length(); i++){
            letters[s.charAt(i)]--;

            if(letters[t.charAt(i)] < 0){
                return false;
            }
        }
       return true; //letters has no neg values, and therefore no pos values either
    }


}
