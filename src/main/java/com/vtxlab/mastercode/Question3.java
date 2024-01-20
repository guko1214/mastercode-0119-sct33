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
                    } 
                    
                }
                chkVos = new boolean[] {false,false,false,false,false};
                allTrue = 0;
                notVowels = 0;
            }
                
        }
        


        return numsVowelWord;
    }

    public static boolean existInArr(char c, char[] arr) {
        boolean chk = false;
        for (char v: arr) {
            if (c == v) 
                chk = true;
        }
        return chk;
    }

    public static void main(String[] args) {
        Question3 q3 = new Question3();
        int intValue = q3.vowelCounts("aeioxu");
        System.out.println(intValue);
    }
}
