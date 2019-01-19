
// Java program to construct binary tree from 
// given array in level order fashion 

public class TreeNode {

    // Tree Node
        int val;
    TreeNode left, right;

    TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    // Function to insert nodes in level order 
    public TreeNode insertLevelOrder(int[] arr, TreeNode root,
                                 int i) {
        // Base case for recursion 
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // insert left child 
            root.left = insertLevelOrder(arr, root.left,
                    2 * i + 1);

            // insert right child 
            root.right = insertLevelOrder(arr, root.right,
                    2 * i + 2);
        }
        return root;
    }
}