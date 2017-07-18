/**
 * Created by ljx on 17-7-18.
 *
 * Find the sum of all left leaves in a given binary tree.
 */
public class Sum_of_Left_Leaves_404 {

    /***
     * 递归
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null || (root.left == null && root.right == null))
            return 0;
        return helper(root, true);
    }

    public int helper(TreeNode root, boolean left) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null && left) {
            return root.val;
        }
        return helper(root.left, true) + helper(root.right, false);
    }

    private void demo() {
        TreeNode node_1 = new TreeNode(3);
        TreeNode node_2 = new TreeNode(9);
        TreeNode node_3 = new TreeNode(20);
        TreeNode node_4 = new TreeNode(15);
        TreeNode node_5 = new TreeNode(7);
        node_1.left = node_2;
        node_1.right = node_3;
        node_3.left = node_4;
        node_3.right = node_5;

        int sum = sumOfLeftLeaves(node_1);
        System.out.println(sum);
    }

    public static void main(String[] args) {
        new Sum_of_Left_Leaves_404().demo();
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
