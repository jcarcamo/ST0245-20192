import java.util.Deque;
import java.util.LinkedList;

public class BinaryTree {
    // Root of the Binary Tree
    private BTNode root;

    public BinaryTree()
    {
        root = null;
    }

    /*TODO:
        Algorithm Inorder(tree)
        1. Traverse the left subtree, i.e., call Inorder(left-subtree)
        2. Visit the root.
        3. Traverse the right subtree, i.e., call Inorder(right-subtree)
    */
    public void printInorder(BTNode node)
    {
        System.out.println("Fix Me: Expected result -> 4 2 5 1 3 ");
    }

    /*TODO:
        Algorithm Preorder(tree)
        1. Visit the root.
        2. Traverse the left subtree, i.e., call Preorder(left-subtree)
        3. Traverse the right subtree, i.e., call Preorder(right-subtree)
    */
    public void printPreorder(BTNode node)
    {
        System.out.println("Fix Me: Expected result -> 1 2 4 5 3 ");
    }

    /*TODO:
        Algorithm Postorder(tree)
        1. Traverse the left subtree, i.e., call Postorder(left-subtree)
        2. Traverse the right subtree, i.e., call Postorder(right-subtree)
        3. Visit the root.
    */
    public void printPostorder(BTNode node)
    {
        System.out.println("Fix Me: Expected result -> 4 5 2 3 1 ");
    }

    /* function to print level order traversal of tree*/
    public void printLevelOrderRecursive()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++) {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    /*TODO: Fix Me To Print The Tree by Level, e.g
    *   Instead of printing 1 2 3 4 5
    *   Print:
    *   1
    *   2 3
    *   4 5
    */
    public void printLevelOrder()
    {
        Deque<BTNode> queue = new LinkedList<BTNode>();
        queue.add(root);
        while (!queue.isEmpty())
        { 

            BTNode tempBTNode = queue.remove();
            System.out.print(tempBTNode.data + " ");

            /*Enqueue left child */
            if (tempBTNode.left != null) {
                queue.add(tempBTNode.left);
            }

            /*Enqueue right child */
            if (tempBTNode.right != null) {
                queue.add(tempBTNode.right);
            }
        }
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    private int height(BTNode root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }

    /* Print nodes at the given level */
    private void printGivenLevel (BTNode root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            /*TODO: Fix Me To Print The Tree*/
        }
    }

    /* Driver program to test above functions */
     /*               1
                   /     \
                  2       3
                /   \
               4     5
     */
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root= new BTNode(1);
        tree.root.left= new BTNode(2);
        tree.root.right= new BTNode(3);
        tree.root.left.left= new BTNode(4);
        tree.root.left.right= new BTNode(5);

        /* Expected output for level order traversals:
            1
            2 3
            4 5
         */
        System.out.println("Iterative Level order traversal of binary tree is ");
        tree.printLevelOrder();

        System.out.println();
        System.out.println();

        System.out.println("Recursive Level order traversal of binary tree is ");
        tree.printLevelOrderRecursive();

        System.out.println();
        System.out.println();

        System.out.println("Inorder traversal of binary tree is ");
        tree.printInorder(tree.root);

        System.out.println();
        System.out.println();

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder(tree.root);

        System.out.println();
        System.out.println();

        System.out.println("Postorder traversal of binary tree is ");
        tree.printPostorder(tree.root);
    }
}

