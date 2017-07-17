/**
 * Created by ljx on 17-7-14.
 *
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

 The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

 Example 1:
 Input: Binary tree: [1,2,3,4]
       1
     /   \
    2    3
   /
  4

 Output: "1(2(4))(3)"

 Explanation: Originallay it needs to be "1(2(4)())(3()())",
 but you need to omit all the unnecessary empty parenthesis pairs.
 And it will be "1(2(4))(3)".
 */
public class Construct_String_from_Binary_Tree_606 {

    public static void main(String[] args) {
        new Construct_String_from_Binary_Tree_606().demo_1();
    }

    private void demo_1() {
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        node_1.left = node_2;
        node_1.right = node_3;
        node_2.left = node_4;
        System.out.println(tree2str(node_1));
    }

    private void demo_2() {
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        node_1.left = node_2;
        node_1.right = node_3;
        node_2.right = node_4;
        System.out.println(tree2str(node_1));
    }

    public String tree2str(TreeNode t) {
        if (t == null) return "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (left=="" && right=="")
            return t.val + "";

        return t.val + "(" + left + ")" + (right=="" ? "" : "(" + right + ")");
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
