package algorithm;

/**
 * author: rale
 * createdAt: 1/24/19
 */
public class MakeTree {

    /**
     * 利用先序表达式和中序表达式构造一棵树
     * 难度：较高
     * @param preOrder 先序表达式
     * @param inOrder 中序表达式
     * @return
     */
    public TreeNode make(String preOrder, String inOrder) {
        if (preOrder==null ||
                inOrder==null ||
                preOrder.isEmpty() ||
                inOrder.isEmpty() ||
                preOrder.length() != inOrder.length()) return null;

        //由先序表达式获得中间节点的值
        char value = preOrder.charAt(0);
        int index = 0;
        while (inOrder.charAt(index) != value) {
            index++;
        }


        String preOrderLeft = preOrder.substring(1, index+1);
        String inOrderLeft = inOrder.substring(0, index);
        TreeNode leftChild = make(preOrderLeft, inOrderLeft);

        String preOrderRight = preOrder.substring(index+1);
        String inOrderRight = inOrder.substring(index+1);
        TreeNode rightChild = make(preOrderRight, inOrderRight);

        TreeNode middle = new TreeNode(value);
        middle.setLeftChild(leftChild);
        middle.setRightChild(rightChild);
        return middle;
    }
}
