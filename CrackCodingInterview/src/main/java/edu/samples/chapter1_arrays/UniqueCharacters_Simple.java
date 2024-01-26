package edu.samples.chapter1_arrays;
/*
   CCI Chapter 1 Arrays and String
   1.1 Implement an algorithm to determine if a string has all unique characters. what if you
   cannot use additional data structures.

   Time complexity for this code is O(n) , where n is the length of the String. The space complexity is O(1).
   You could also argue the time complexity is O(1) , since the for loop will never iterate through more than
   128 characters. If you didn't want to assume the character set is fixed , you could express the complexity
   as O(c) space and O(min(c,n)) or O(c) time , where c is the size of the character set.
 */
public class UniqueCharacters_Simple {

public static void main(String[]args){

        System.out.println( "Is 'stridngh'  a Unique Character String ? Answer =>  " + isUniqueChars("stridngh"));

        System.out.println( "Is 'addhi'  a Unique Character String ? Answer =>  " + isUniqueChars("addhi"));

    }


        static boolean  isUniqueChars(String str){

          //There is only 128 unique ASCII characters defined. Anything above that count clearly proves
            // same unique characters are repeating
         if(str.length() > 128) return false;

          boolean [] char_at = new boolean[128];

          for ( int i=0; i < str.length() ; i++){

              int val = str.charAt(i);

              if(char_at[val]) {
                  return false;
              }else{
                  char_at[val] = true;
              }
         }

          return true;

      }

}