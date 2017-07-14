/**
 * Created by ljx on 17-7-14.
 *
 * 问题描述：
 *   Given a Binary Search Tree (BST), convert it to a Greater Tree
 * such that every key of the original BST is changed to the original key
 * plus sum of all keys greater than the original key in BST.
 *
 * Input: The root of a Binary Search Tree like this:
        5
      /   \
     2    13

   Output: The root of a Greater Tree like this:
       18
     /   \
    20   13
 */
public class Convert_BST_to_Greater_Tree_538 {
    private Convert_BST_to_Greater_Tree_538() {}

    /**
     * 思路：利用二叉搜索树的特性：当前结点、左孩子、右孩子三者中，右孩子的值最大，
     * 　　　所以可以中序遍历二叉树（按右中左的顺序），在遍历时同时累加遍历过的结点的值，
     * 　　　记为current，在更新某个结点值时，只需在原来值的基础上加上current.
     */
    private TreeNode convertBST(TreeNode root) {
        inOrder(root, 0);
        return root;
    }

    private void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.val);
            inOrder(node.right);
        }
    }

    private int inOrder(TreeNode node, int current) {
        if (node != null) {
            current = inOrder(node.right, current);
            node.val += current;
            current = node.val;
            current = inOrder(node.left, current);
        }
        return current;
    }

    private void demo() {
        TreeNode node_1 = new TreeNode(5);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(13);
        node_1.left = node_2;
        node_1.right = node_3;
        inOrder(node_1);
        TreeNode new_root = convertBST(node_1);
        inOrder(new_root);
    }

    public static void main(String[] args) {
        new Convert_BST_to_Greater_Tree_538().demo();
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
