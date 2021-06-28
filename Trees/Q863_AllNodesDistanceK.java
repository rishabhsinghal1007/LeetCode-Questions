/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public boolean nodeToRootPath(TreeNode root, int data, ArrayList<TreeNode> ans) {
        if (root == null) {
            return false;
        }

        if (root.val == data) {
            ans.add(root);
            return true;
        }

        boolean res = nodeToRootPath(root.left, data, ans) || nodeToRootPath(root.right, data, ans);

        if (res)
            ans.add(root);
        return res;
    }

    public void kDown(TreeNode root, TreeNode blockNode, int k, List<Integer> ans) {
        if (root == null || root == blockNode || k < 0) {
            return;
        }

        if (k == 0) {
            ans.add(root.val);
            return;
        }

        kDown(root.left, blockNode, k - 1, ans);
        kDown(root.right, blockNode, k - 1, ans);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> path = new ArrayList<>();
        nodeToRootPath(root, target.val, path);

        List<Integer> ans = new ArrayList<>();
        TreeNode blockNode = null;

        for (int i = 0; i < path.size(); i++) {
            if (k - i < 0) {
                break;
            }
            kDown(path.get(i), blockNode, k - i, ans);
            blockNode = path.get(i);
        }

        return ans;
    }
}