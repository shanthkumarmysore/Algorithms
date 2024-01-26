package edu.samples.chapter1_arrays;

/*
     Write a function to compress the given string by counting the repeated sequence character and appending that info in
     front of letter.
     Input : 'aabccccccaa'
     Output: a2b1c6a2


 */
public class StringCompression_countrepeatchars {

    public static void main(String[] args) {
        System.out.println("Compressing string of 'aabccccccaa' using first method is => " +Compress_StringBuilderOptimization("aabccccccaa") );
        System.out.println("Compressing string of 'aabccccccaa' using optimized method is => " + compress_optimized("aabccccccaa") );

    }

    //Runtime of this function O(P+k2) where P is the length of original string. Here  we check the size of original
    // and compressed string in the end.
    static String Compress_StringBuilderOptimization(String str){
        int countConsecutive = 0;
        StringBuilder compressString = new StringBuilder();

        for(int i =0 ; i < str.length() ; i++){
            countConsecutive++;

            if( i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
                compressString.append(str.charAt(i)).append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressString.length() > str.length() ? str : compressString.toString();
    }

    /////////////////////////

    //This is more optimized as in the case of large string and no repeating sequence letters. Here first we count the length
   // of the compressed string instead of actually compressing the string. Here we can create a StringBuilder with
    //fixed size which reduces our stringbuilder to resize in append operation
    static String compress_optimized(String str){
        int finalLength = countCompression(str);

        if( finalLength >= str.length()) return str;

        int countConsecutive = 0;
        StringBuilder compressedString = new StringBuilder(finalLength);

        for(int i =0 ; i < str.length() ; i++){
            countConsecutive++;

            if( i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
                compressedString.append(str.charAt(i)).append(countConsecutive);
                countConsecutive = 0;
            }
        }

       return compressedString.toString();
    }

    static int countCompression(String str){
        int compressedLength = 0;
        int countConsecutive = 0;

        for(int i =  0; i < str.length(); i++){
            countConsecutive++;

            // If next character is different than current increase the length.

            if( i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
                compressedLength += 1 + String.valueOf(countConsecutive).length();

                countConsecutive = 0;
            }
        }

        return compressedLength;
    }
}
