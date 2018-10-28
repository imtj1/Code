class Solution {
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        return sum;
    }

    public int maxPathSummer(TreeNode root) {
        sum = Math.max(root.val, sum);
        if(root.left == null && root.right == null){
            return root.val;
        }
        int leafMax = Integer.MIN_VALUE;
        int subTreeMax = root.val;

        if(root.left != null){
            int leftSum = maxPathSummer(root.left);
            leafMax = Math.max(leafMax, leftSum);
            subTreeMax += leftSum;
        }

        if(root.right != null){
            int rightSum = maxPathSummer(root.right);
            leafMax = Math.max(leafMax, rightSum);
            subTreeMax += rightSum;
        }

        int maxOneSidedSum = Math.max(root.val, root.val + leafMax);


        sum = Math.max(subTreeMax,sum);
        sum = Math.max(maxOneSidedSum,sum);

        return maxOneSidedSum;
    }
    public static void main(String args[])
    {
        TreeNode t2 = new TreeNode(-2);
        int arr[] = { -1,0,9,0,0,-6,3,0,0,0,0,0,0,0,-2};
        t2 = t2.insertLevelOrder(arr, t2, 0);
        int n = new Solution().maxPathSum(t2);
        System.out.println(n);
    }


}