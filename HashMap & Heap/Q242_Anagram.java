import java.io.*;
import java.util.*;

public class Q242_Anagram{

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length())
            return false;
        
        int[] freq = new int[26];
        for(int i = 0; i < s.length() ; i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for(int i = 0 ; i < 26; i++){
            if(freq[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str1 = scn.nextLine();
        String str2 = scn.nextLine();
        System.out.println(isAnagram(str1, str2));
    }
}