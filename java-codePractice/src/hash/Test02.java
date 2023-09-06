package hash;

import java.util.HashMap;
import java.util.Map;


public class Test02 {
    public boolean canConstruct(String ransomNote, String magazine) {
       if (magazine == null && ransomNote != null) return false;
        if (magazine == null && ransomNote == null) return true;
//        Map<Character,Integer> hashmap = new HashMap<>();
//        for (int i = 0; i < magazine.length(); i++) {
//            if (!hashmap.containsKey(magazine.charAt(i))) {
//                hashmap.put(magazine.charAt(i),1);
//            }else {
//                hashmap.put(magazine.charAt(i),hashmap.get(magazine.charAt(i))+1);
//            }
//        }
//        for (int i = 0; i < ransomNote.length(); i++) {
//            if (hashmap.containsKey(ransomNote.charAt(i))) {
//                if ( hashmap.get(ransomNote.charAt(i)) < 1) {
//                    return false;
//                }else {
//                hashmap.put(ransomNote.charAt(i),hashmap.get(ransomNote.charAt(i))-1);}
//            }else {
//                return false;
//            }
//        }
//        return true;
        char[] hash = new char[26];
        for (int i = 0; i < magazine.length(); i++) {
            hash[magazine.charAt(i)-97]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (hash[ransomNote.charAt(i)-97] == 0) {
                return false;
            }else {
                hash[ransomNote.charAt(i)-97]--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "nulll";
        String b = "null";
        Test02 test02 = new Test02();
        System.out.println(test02.canConstruct(a, b));
    }
}
