package com.vtxlab.mastercode;

public class Question3 {

    public int vowelCounts(String word) {
        String chkStr = "";
        char[] vowels = new char[] {'a','e','i','o','u'};
        boolean[] chkVos = new boolean[] {false,false,false,false,false};
        char c = ' ';
        int numsVowelWord = 0;
        int allTrue = 0;
        int notVowels = 0;
        for (int i = 0; i < word.length(); i++){
            for (int j = 0; j < word.length() -i +1; j++) {
                chkStr = word.substring(i, i+j);
                for (int k = 0; k < chkStr.length();k++ ) {
                    c = chkStr.charAt(k);
                    for (int l = 0; l < vowels.length; l++) {
                        if (c == vowels[l]) {
                            chkVos[l] = true;
                        }
                    }
                }
                for (int m = 0; m < chkVos.length; m++) {
                    if (chkVos[m] == false) {
                        allTrue = 0;
                        notVowels = 0;
                        chkVos = new boolean[] {false,false,false,false,false};                     
                        break;
                    }
                    allTrue++;
                }
                if (allTrue == 5) {
                    //System.out.println(chkStr);
                    for (int n = 0; n < chkStr.length();n++ ) {
                        if (!existInArr(chkStr.charAt(n), vowels)) {
                            ++notVowels;
                        }
                    }
                    if (notVowels == 0) {
                        ++numsVowelWord;
                        System.out.println(chkStr);
                    } 
                    
                }
                chkVos = new boolean[] {false,false,false,false,false};
                allTrue = 0;
                notVowels = 0;
            }
                
        }
        return numsVowelWord;
        // int numsVowelWord = 0;
        // //String chkStr = "";
        // int countContinuVow = 0;
        // char[] vowels = new char[] {'a','e','i','o','u'};
        // char[] wordArr = word.toCharArray();
        // boolean[] allVowelsExist = new boolean[] {false,false,false,false,false};
        // for (int i = 0; i < wordArr.length; i++) {            
  
        //     for (int j = i + 5; j < wordArr.length + 1; j++) {
        //         if (j-i < 5) {
        //             continue;
        //         }
        //         // System.out.println("i="+i+",j=" + j);                
        //         countContinuVow = 0;
        //         allVowelsExist = new boolean[] {false,false,false,false,false};
        //         // System.out.println("----");
        //         for (int k = i; k < j;k++) {
        //             // System.out.println(wordArr[k]);                    
        //             if (existInArr(wordArr[k],vowels)) {               
        //                 ++countContinuVow;
        //                 for (int l = 0; l < allVowelsExist.length; l++) {
        //                     if (wordArr[k] == vowels[l]) {
        //                         allVowelsExist[l] = true;
        //                     }
        //                 }
        //             } else {
        //                 countContinuVow = 0;
        //                 break;
        //             }

        //         }
        //         if (countContinuVow < 5) {
        //             // System.out.println(countContinuVow);
        //         }
        //         if (countContinuVow >= 5) {
        //             if (allTrue(allVowelsExist)) {
        //                 ++numsVowelWord;
        //             }                    
        //             // System.out.println(countContinuVow);
        //             // System.out.println(numsVowelWord);
        //         }
        //     }    
        //     // System.out.println(numsVowelWord);  
        // }
        // return numsVowelWord;

    }

    public static boolean existInArr(char c, char[] arr) {
        boolean chk = false;
        for (char v: arr) {
            if (c == v) 
                chk = true;
        }
        return chk;
    }

    public static boolean allTrue(boolean[] arr) {
        boolean prechk = true;
        for (boolean b : arr) {
            if (b == false) {
                return false;
            }
        }
        return prechk;
    }

    public static void main(String[] args) {
        Question3 q3 = new Question3();
        int intValue = q3.vowelCounts("aeiouu");
        System.out.println(intValue);
    }
}
