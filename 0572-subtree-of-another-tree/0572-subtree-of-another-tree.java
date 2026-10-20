/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


import java.util.*;

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        List<String> text = new ArrayList<>();
        List<String> pattern = new ArrayList<>();

        serialize(root, text);
        serialize(subRoot, pattern);

        return kmp(text, pattern);
    }

    private void serialize(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("#");
            return;
        }

        list.add("N" + node.val);
        serialize(node.left, list);
        serialize(node.right, list);
    }

    private boolean kmp(List<String> text, List<String> pattern) {
        int[] lps = buildLPS(pattern);

        int i = 0;
        int j = 0;

        while (i < text.size()) {
            if (text.get(i).equals(pattern.get(j))) {
                i++;
                j++;

                if (j == pattern.size()) {
                    return true;
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return false;
    }

    private int[] buildLPS(List<String> pattern) {
        int[] lps = new int[pattern.size()];
        int len = 0;
        int i = 1;

        while (i < pattern.size()) {
            if (pattern.get(i).equals(pattern.get(len))) {
                lps[i] = ++len;
                i++;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }
}

