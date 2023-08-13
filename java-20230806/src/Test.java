import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Test {
    public static int firstUniqChar(String s) {
        int[] hash = new int[25];
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            hash[tmp-97]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (hash[tmp-97] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //int[] arr = new int[100_000];
       int[] arr = {1,1,4,2,5,2,5,6,22,4,6,7,9,16,15,22};
        Map<Integer,Integer> map = new HashMap<>();
        for (int x: arr) {
            int count = 0;
            if (map.get(x) == null) {
                map.put(x,count);
            }else {
//                map.get();
            }
        }
        System.out.println(map);
    }
    public static void main2(String[] args) {
        int[] arr = {1,2,5,2,7,3,8,3};
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hashSet.add(arr[i]);
        }
        System.out.println(hashSet);
    }
    public static void main1(String[] args) {
        String s = "abasef";
        System.out.println(firstUniqChar(s));
    }
}
