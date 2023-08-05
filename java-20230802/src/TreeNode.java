public class TreeNode {
    static class Node{
        int val;
        public Node leftNode;
        public Node rightNode;

        public Node(int val) {
            this.val = val;
        }
    }
    public Node root;
    public void inSert(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        Node p = null;
        Node cur = root;
        while (cur != null) {
            p = cur;
            if (val > cur.val) {
                cur = cur.rightNode;
            } else if (val < cur.val) {
                cur = cur.leftNode;
            }
        }
        if (p.val > val) {
            p.leftNode = new Node(val);
        }else {
            p.rightNode = new Node(val);
        }
    }
    public Node find(Node root,int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        Node retRight = null;
        Node retleft = null;
        if (val > root.val) {
            retRight = find(root.rightNode,val);
        } else {
            retleft = find(root.leftNode,val);
        }
        return retleft!=null?retleft:retRight;
    }
}