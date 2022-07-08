class Solution {
public String firstPalindrome(String []words){
    for (int i = 0; i < words.length; i++) {
        if (checkPalindrome(words[i])){
            return words[i];
        }
    }
    return "";
}

public boolean checkPalindrome(String string){
    int start = 0;
    int end = string.length() - 1;
    while(start < end){
        if (string.charAt(start++) != string.charAt(end--)){
            return false;
        }
    }
    return true;
}
}
