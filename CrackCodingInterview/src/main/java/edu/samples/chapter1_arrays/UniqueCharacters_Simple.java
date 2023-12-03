package edu.samples.chapter1_arrays;
/*
   CCI Chapter 1 Arrays and String
   1.1 Implement an algorithm to determine if a string has all unique characters. what if you
   cannot use additional data structures.
 */
public class UniqueCharacters_Simple {

public static void main(String[]args){

        System.out.println( "Is 'stridngh'  a Unique Character String ? Answer =>  " + isUniqueChars("stridngh"));

        System.out.println( "Is 'stridngh'  a Unique Character String ? Answer =>  " + isUniqueChars("addhi"));

    }


        static boolean  isUniqueChars(String str){

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