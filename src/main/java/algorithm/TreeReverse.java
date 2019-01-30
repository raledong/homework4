package algorithm;

/**
 * author: rale
 * createdAt: 1/24/19
 */
public class TreeReverse {

    /**
     * 使用递归的方法交换树中所有的左右节点
     * 难度：中等
     * @param root
     * @return
     */
    public TreeNode reverse(TreeNode root) {
        if (root == null) return null;


        TreeNode tmp = root.getLeftChild();
        root.setLeftChild(root.getRightChild());
        root.setRightChild(tmp);


        reverse(root.getLeftChild());
        reverse(root.getRightChild());
        return root;
    }
}
