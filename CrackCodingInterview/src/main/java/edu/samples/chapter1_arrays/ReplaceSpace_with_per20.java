package edu.samples.chapter1_arrays;

import java.util.Arrays;

/*
Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient
space at the end to hold the additional characters,and that you are given the "true" length of the string.
If implementing in Java , please use a character array so that you can perform this operation in place.

Example Input "Mr John Smith   ",13
        Output "Mr%20John%20Smith"

A common approach in string manipulation problems is to edit the string starting from the end and working backwards.
This is useful because we have an extra buffer at the end, which alllows us to change characters without worrying about
what we're overwriting.

We follow this approach. The algorithm employs a two scan approach. In the first scan, we count the number of spaces.
By tripling this number , We can compute how many extra characters we will have in the final string. In the second
pass, which is done in reverse order, we actually edit the string,when we see a space,we replace it with %20. If there
is no space,then we copy the original character.

 */
public class ReplaceSpace_with_per20 {

//char array is used as Java strings are immutable and if string used directly the function will return
  //  a new copy of the string
static char[] replaceSpaces(char[] str , int truelength){

    int spaceCount = 0, index , i =0;

    for(i = 0; i < truelength ; i++){
        if(str[i] == ' ') {
            spaceCount++;
        }
     }

    index = truelength + spaceCount *2;

    if (truelength < str.length) {
        str[truelength] = '\0'; //End Array
    }

    for( i = truelength-1 ; i >= 0 ; i--){

        if (str[i] == ' ') {
           str[index - 1] = '0';
           str[index - 2] = '2';
           str[index - 3] = '%';
           index = index -3 ;
        }else{
            str[index-1] = str[i];
            index--;
        }
    }

    return str;
 }

    public static void main(String[] args) {

        String s = "Mr John Smith       ";

        char[] str = replaceSpaces(s.toCharArray(),13);
        System.out.println("Replacing space with '%20' character in passed string => '" +s + "' is => " +  String.copyValueOf(str));
        String t = "Shantha  Kumar Smith      ";
        char[] tstr = replaceSpaces(t.toCharArray(),20);
        System.out.println("Replacing space with '%20' character in passed string => '" +t + "' is => " +  String.copyValueOf(tstr));
    }

}
