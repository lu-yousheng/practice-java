public class Sort {
    public static void insertSort(int[] arr) {
//        int tmp = 0;
//        for (int i = 1; i < arr.length; i++) {
//            int j = i - 1;
//            if (arr[i] < arr[j]) {
//                tmp = arr[i];
//                while (j >= 0) {
//                    if (arr[j] > tmp) {
//                        arr[j+1] = arr[j];
//                        j--;
//                    } else {
//                        break;
//                    }
//                }
//                arr[j+1] = tmp;
//               // arr[0] = tmp;
//            }
//        }
        int tmp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int j = i + 1;
            if (arr[i] > arr[j]) {
                tmp = arr[j];
                int x = i;
                while (x >= 0) {
                    if (arr[x] > tmp) {
                        arr[x+1] = arr[x];
                        x--;
                    } else {
                        break;
                    }
                }
                arr[x+1] = tmp;
                // arr[0] = tmp;
            }
        }

    }
    public static void shellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            shell(arr,gap-1);
            gap /= 2;
        }
        //整体进行插入排序
        //insertSort(arr);
    }
    private static void shell(int[] arr,int gap) {
        int tmp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int j = i + gap;
            if (j >= arr.length) {
                break;
            }
            if (arr[i] > arr[j]) {
                tmp = arr[j];
                int x = i;
                while (x >= 0) {
                    if (arr[x] > tmp) {
                        arr[x+gap]= arr[x];
                        x-=gap;
                    } else {
                        break;
                    }
                }
                arr[x+gap] = tmp;
                // arr[0] = tmp;
            }
        }


    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            int minIndex = i;
            while (j < arr.length) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                j++;
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

    public static void quickSort(int[] arr) {
        quick(arr,0,arr.length-1);
    }
    private static void swap(int[]arr,int right,int left) {
        int tmp = arr[right];
        arr[right] = arr[left];
        arr[left] = tmp;
    }
    private static void quick(int[] arr,int left,int right) {
        if (left >= right) {
            return;
        }
        int tmp = arr[left];
        int inLeft = left;
        int inRight = right;
        while (inLeft < inRight) {
            while (inLeft <= inRight && arr[inRight] > tmp) {
                inRight--;
            }
            if (inLeft <= inRight && arr[inRight] < tmp) {
                arr[inLeft] = arr[inRight];
            }
            while (inLeft < inRight && arr[inLeft] < tmp) {
                inLeft++;
            }
            if (inLeft < inRight && arr[inLeft] > tmp) {
                arr[inRight] = arr[inLeft];
            }
//            inRight--;
//            inLeft++;
         }
        arr[inLeft] = tmp;
        quick(arr,left,inRight);
        //quick(arr,inLeft,right);
    }
}
