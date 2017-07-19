/**
 * Created by ljx on 17-7-19.
 *
 * Given two binary trees, write a function to check if they are equal or not.

   Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class Same_Tree_100 {

    public static void main(String[] args) {
        new Same_Tree_100().demo();
    }


    private void demo() {
        TreeNode tree_1_node_1 = new TreeNode(1);
        TreeNode tree_1_node_2 = new TreeNode(2);
        TreeNode tree_1_node_3 = new TreeNode(3);
        tree_1_node_1.left = tree_1_node_2;
        tree_1_node_1.right = tree_1_node_3;

        TreeNode tree_2_node_1 = new TreeNode(1);
        TreeNode tree_2_node_2 = new TreeNode(2);
        TreeNode tree_2_node_3 = new TreeNode(4);
        tree_2_node_1.left = tree_2_node_2;
        tree_2_node_1.right = tree_2_node_3;

        boolean b = isSameTree(tree_1_node_1, tree_2_node_1);
        System.out.println(b);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null)
            return true;
        if ((p==null && q!=null) || (p!=null && q==null))
            return false;
        if (p.val != q.val)
            return false;
        if (!isSameTree(p.left, q.left))
            return false;
        if (!isSameTree(p.right, q.right))
            return false;
        return true;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
}
