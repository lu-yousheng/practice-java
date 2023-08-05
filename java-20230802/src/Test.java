import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.inSert(5);
        treeNode.inSert(1);
        treeNode.inSert(4);
        treeNode.inSert(7);
        treeNode.inSert(3);
        treeNode.inSert(0);
//        TreeNode.Node ret = treeNode.find(treeNode.root,0);
        System.out.println(treeNode.find(treeNode.root,0).val);
    }
    public static void main1(String[] args) {
        int[] arr = {6,1,2,7,9,3,4,5,10,8};
        //Sort.insertSort(arr);
        //Sort.shellSort(arr);
        //Sort.selectSort(arr);
        Sort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
