
/**
 * Created by ljx on 17-7-18.
 *
 * 题目描述：
 * https://leetcode.com/problems/binary-tree-tilt/#/description
 */
public class Binary_Tree_Tilt_563 {

    /***
     * 思路：利用中序遍历的思想，先求左子树的tilt，再求右子树的tilt，最后求中间节点的tilt，
     *      为了避免重复计算子树结点的求和，在求完左右子树的tilt后，在中间结点的值上加上左右
     *      子节点的值。
     */
    public int findTilt(TreeNode root) {
        if (root==null || (root.left==null && root.right==null))
            return 0;
        int result = 0;
        if (root.left != null) {
            result += findTilt(root.left);
            root.val += root.left.val;
        }
        if (root.right != null) {
            result += findTilt(root.right);
            root.val += root.right.val;
        }
        int leftVal = root.left!=null ? root.left.val : 0;
        int rightVal = root.right!=null ? root.right.val : 0;
        return result + Math.abs(leftVal - rightVal);
    }

    private void demo() {
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(4);
        TreeNode node_4 = new TreeNode(3);
        TreeNode node_5 = new TreeNode(5);
        node_1.left = node_2;
        node_1.right = node_4;
        node_2.left = node_3;
        node_4.left = node_5;
        int result = findTilt(node_1);
        System.out.println(result);
    }

    public static void main(String[] args) {
        new Binary_Tree_Tilt_563().demo();
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
