package demo01;

import java.util.*;


public class Test {
    public static boolean IsPopOrder (int[] pushV, int[] popV) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0;i < pushV.length;i++) {
            stack.push(pushV[i]);
            while( !stack.empty()&& j < popV.length && stack.peek() == popV[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] pop = {3,2,4,1,5};
        System.out.println(IsPopOrder(push, pop));
    }
}
