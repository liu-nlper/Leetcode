/**
 * Created by ljx on 17-7-14.
 *
 * Invert a binary tree.

       4
    /    \
   2     7
  / \   / \
 1  3  6  9

 to

      4
    /    \
   7     2
  / \   / \
 9  6  3  1

 */
public class Invert_Binary_Tree_226 {

    /**
     * 思路：递归交换左右子树
     */
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode node) {
        if (node != null) {
            swapChildren(node);
            invert(node.left);
            invert(node.right);
        }
    }

    /**
     * 交换node的左右孩子结点
     */
    private void swapChildren(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    private void demo() {
        TreeNode node_1 = new TreeNode(4);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(7);
        TreeNode node_4 = new TreeNode(1);
        TreeNode node_5 = new TreeNode(3);
        TreeNode node_6 = new TreeNode(6);
        TreeNode node_7 = new TreeNode(9);
        node_1.left = node_2;
        node_1.right = node_3;
        node_2.left = node_4;
        node_2.right = node_5;
        node_3.left = node_6;
        node_3.right = node_7;

        TreeNode root = invertTree(node_1);
        preorder(root);
    }

    private void preorder(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public static void main(String[] args) {
        new Invert_Binary_Tree_226().demo();
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
