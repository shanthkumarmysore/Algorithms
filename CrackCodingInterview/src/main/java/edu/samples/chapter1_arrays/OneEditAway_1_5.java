package edu.samples.chapter1_arrays;

/*
  Q:: There are three types of edits that can be performed on strings: insert a character, remove a character , or replace a character. Given two strings, write a function to
   check if they are one edit(or zero edits) away.
   Example pale, ple -> true
           pales, pale -> true
           pale, bale - > true
           pale, bake -> false

   H:: Brute force approach is to check all possible strings that are one edit away by testing the removal of each character(and comparing), testing the replacement
   of each character(and comparing), and then testing the insertion of each possible character(and comparing). Its very slow and not a good solution.

   Consider

   Replacement: bale and pale  requires one replacement away to replace b with p. These two string different from one place.

   Insertion: The strings apple and aple are one insertion away

   Removal: The strings apple and aple are also one removal away

   In implementing we can merge insertion and removal check into one and check the replacement step separately. We don't need to check the strings for insertion, removal or replacement
   edits. The lengths of the strings will indicate which of these you need to check.

 */
public class OneEditAway_1_5 {

    public static void main(String[] args) {
        System.out.println(" Are Strings 'apple' and 'aple' are oneEditAway => "+oneEditAway("apple" , "aple"));
        System.out.println(" Are Strings 'bale' and 'pale' are oneEditAway => "+oneEditAway("bale" , "pale"));
        System.out.println(" Are Strings 'bape' and 'pale' are oneEditAway => "+oneEditAway("bape" , "pale"));
        System.out.println(" Are Strings 'shanth' and 'pale' are kumar => "+oneEditAway("shanth" , "kumar"));
    }

    static boolean oneEditAway(String first, String second){
        if(first.length() == second.length()){
          return oneEditReplace(first,second);
        }else if(first.length()+1 == second.length()){
          return oneEditInsert(first,second);
        }else if(first.length()-1 == second.length()){
            return oneEditInsert(second,first);
        }
        return false;
    }

    static boolean oneEditReplace(String s1, String s2){
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) {
                if(foundDifference) { // checking only once condition
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    static boolean oneEditInsert(String s1, String s2){

        int index1 =0 ;
        int index2=0;

        while( index2 < s2.length() && index1 < s1.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(index1 != index2){  // checking only once condition
                   return false;
                }
                index2++;
            }else{
                index1++;
                index2++;
            }
        }
        return true;
    }
}
