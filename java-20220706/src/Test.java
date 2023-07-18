import java.sql.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arrSame = new int[]{1,2,3,3,1,3,3};
        System.out.println(arrFunc(arrSame));
    }
    public static int arrFunc(int[] arr){
        int stard = arr.length/2;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count > stard){
                return arr[i];
            }
        }
        return -1;
    }
    public static void main3(String[] args) {
        int[] arrFind = new int[]{1,2,3,4,5,6,7,8,9,10};
        int key = 11;
        System.out.println(midFind(arrFind, key));
    }
    public static int  midFind(int[] arr,int k){
        int left = 0;
        int right = arr.length-1;
        int mid  = 0;
        while (left < right){
            mid = (left + right)/2;
            if(arr[mid] == k){
                return arr[mid];
            }
            else if(arr[mid] < k){
                left = arr[mid];
            }
            else {
                right = arr[mid];
            }
        }
        if(left >= right) {
            System.out.println("没找到！");
        }
        return -1;
    }
    public static void main2(String[] args) {
        int[] arr = new int[]{1,3,1,6,7,9,0,4,5};
        int pre = 0;
        int end = arr.length-1;
       while (pre < end){
           while (pre < arr.length){
               if(arr[pre] %2 == 0){
                   break;
               }
               pre++;
           }
           while (end > 0){
               if(arr[end] % 2 != 0){
                   break;
               }
               end--;
           }
          if(pre < end){
              int tmp = 0;
              tmp = arr[pre];
              arr[pre] = arr[end];
              arr[end] = tmp;
          }
       }
        System.out.println(Arrays.toString(arr));
    }
    public static void main1(String[] args) {
        int[] arry = new int[]{1,3,1,6,7,9,0,4,5};
        int[] arrOdd = new int[arry.length];
        int[] arrEven = new int[arry.length];
        int odd = 0;
        int even = 0;
        for (int i = 0; i < arry.length; i++) {
            if(arry[i]%2 != 0){
                arrOdd[odd] = arry[i];
                odd++;
            }
            else {
                arrEven[even] = arry[i];
                even++;
            }
        }
        arry = arrOdd;
        if(odd != arry.length){
            for (int j = 0; j < even; j++) {
                arry[odd] = arrEven[j];
                odd++;
            }
        }
        System.out.println(Arrays.toString(arry));
        System.out.println(Arrays.toString(arrEven));
    }
}
