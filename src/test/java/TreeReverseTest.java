import algorithm.TreeNode;
import algorithm.TreeReverse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * author: rale
 * createdAt: 1/24/19
 */
public class TreeReverseTest {

    private TreeReverse reverse;

    @Before
    public void before() {
        reverse = new TreeReverse();
    }

    @Test
    public void testNull() {
        TreeNode result = reverse.reverse(null);
        Assert.assertNull(result);
    }

    @Test
    public void test() {
        TreeNode input = new TreeNode();
        input.setLetter('a');

        TreeNode left = new TreeNode();
        left.setLetter('b');
        input.setLeftChild(left);

        TreeNode right = new TreeNode();
        right.setLetter('c');
        input.setRightChild(right);

        TreeNode result = reverse.reverse(input);

        TreeNode expect = new TreeNode();
        expect.setLetter('a');
        expect.setRightChild(left);
        expect.setLeftChild(right);

        Assert.assertEquals(expect, result);
    }
}
