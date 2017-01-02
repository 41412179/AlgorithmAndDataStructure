package 二叉树的下一个节点;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // if this node is null, return
        if (null == pNode) {
            return pNode;
        }
        // if this node has right child
        TreeLinkNode tmp = pNode.right;
        if (tmp != null) {
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            return tmp;
        }

        while (true) {
            TreeLinkNode p = pNode.next;
            if (p == null)
                return null;
            if (p.left == pNode) {
                return p;
            } else {
                pNode = p;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().GetNext(null);
    }
}