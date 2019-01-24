import algorithm.MakeTree;
import algorithm.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * author: rale
 * createdAt: 1/24/19
 */
public class MakeTreeTest {

    private MakeTree makeTree;

    @Before
    public void before() {
        makeTree = new MakeTree();
    }
    @Test
    public void testNull() {
        String preOrder = "";
        String inOrder = "";

        TreeNode node = makeTree.make(preOrder, inOrder);
        Assert.assertNull(node);
    }

    @Test
    public void test() {
        String preOrder = "abc";
        String inOrder = "bac";

        TreeNode result = makeTree.make(preOrder, inOrder);

        TreeNode expect = new TreeNode();
        expect.setLetter('a');

        TreeNode left = new TreeNode();
        left.setLetter('b');
        expect.setLeftChild(left);

        TreeNode right = new TreeNode();
        right.setLetter('c');
        expect.setRightChild(right);

        Assert.assertEquals(expect, result);
    }
}
