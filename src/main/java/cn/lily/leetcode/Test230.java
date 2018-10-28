package cn.lily.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Test230 {
    public static int kthSmallest(TreeNode root, int k) {
        PriorityQueue<TreeNode> pq = new PriorityQueue<>((p,q) ->(q.val - p.val));
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (pq.size() < k && ! list.isEmpty()){
            TreeNode node =list.pop();
            pq.offer(node);
            if (node.left != null)
                list.add(node.left);
            if (node.right != null)
                list.add(node.right);
        }
        while (!list.isEmpty()){
            TreeNode temp = list.pop();
            if (temp.val < pq.peek().val){
                pq.poll();
                pq.offer(temp);
            }
            if (temp.left != null)
                list.add(temp.left);
            if (temp.right != null)
                list.add(temp.right);
        }

        return pq.peek().val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(kthSmallest(root, 3));
    }
}
