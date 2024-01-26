package edu.samples.chapter1_arrays;

/*
Given a string and write a function to check if it's a permutation of a palindrome or not.It's not limited
to just dictionary words.

Input: Tact Coa
Output: True(permutation:"taco cat",atco cta",etc)

A palindrome is a string that is same forwards and backwards. We need to have an even number of almost
all characters, so that half can be on one side and half can be on the other side. At most one character(the
middle character) can have an odd count. For example "tactcoapapa" is a permutation of a palindrome because
it has two Ts, four As, two c's, two Ps, and one O. That O would be the center of all possible palindromes.

This algorithm takes O(N) time, Where N is the length of the string.
 */
public class Permutation_Palindrome {

    public static void main(String[] args) {
        System.out.println("'Tact Coa' is a Permutation of Palindrome =>"+ isPermutationOfPalindrome("Tact Coa"));
        System.out.println("'Tact Coa' is a Permutation of Palindrome using Solution2 => "+ isPermutationPalindrome_optimized_Solution2("Tact Coa"));

    }

    static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    static boolean checkMaxOneOdd(int[] table){

        boolean foundOdd = false;

        for (int count : table){

            if(count % 2 == 1){

                if(foundOdd) return false;

                foundOdd = true;
            }
        }
        return true;
    }

    static int[] buildCharFrequencyTable(String phrase){
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for ( char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if( x!= -1){
                table[x]++;
            }
        }
        return table;
    }

    static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        // To check character in phrase lies within a to z letters.
        if(a <= val && val <=z){
            return val-a;
        }

        return -1;
    }
//==========================================================================================================================================================

    // Here instead of checking the number of odd counts at the end , we can check as we go along.We eliminated a final iteration through the hash table,
    //but now we have to run a few extra lines of code for each character in the string.
    static boolean isPermutationPalindrome_optimized_Solution2(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if(x != -1){
                table[x]++;

                if(table[x] % 2 == 1){
                    countOdd++;
                }else{
                    countOdd--;
                }
            }
        }
        return countOdd <=1;
    }
}
