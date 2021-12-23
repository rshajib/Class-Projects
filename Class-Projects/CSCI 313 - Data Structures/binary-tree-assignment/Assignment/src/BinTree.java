
// Redowan Shajib

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("unused")
class BinTree {

    private BinNode root;
    private int size;

    BinTree() {
        root = null;
        size = 0;
    }

    BinTree(List<Integer> input) {
        if (input.size() == 0) {
            return;
        }
        root = new BinNode(input.get(0));
        size++;
        final Random rng = new Random();
        for (int i = 1; i < input.size(); i++) {
            int rand = rng.nextInt();
            if (rand % 2 == 0) {
                BinNode node = findEmptyLeftChild(root);
                node.setLeft(new BinNode(input.get(i)));
            } else {
                BinNode node = findEmptyRightChild(root);
                node.setRight(new BinNode(input.get(i)));
            }
            size++;
        }
    }

    public int getSize() {
        return size;
    }

    public BinNode getRoot() {
        return root;
    }

    public int totalSum() {
        if (root == null) {
            return -1;
        }
        Stack<BinNode> ss = new Stack<BinNode>();
        BinNode current = root;
        int sum = 0;
        while (current != null || ss.size() > 0) {
            while (current != null) {
                ss.push(current);
                current = current.getLeft();
            }
            current = ss.pop();
            sum = sum + current.getData();
            current = current.getRight();
        }
        return sum;
    }

    public int height() {
        //return the height of the tree
        if (root == null) {
            return 0;
        }
        Queue<BinNode> que = new LinkedList();

        que.add(root);
        int height = 0;

        while (3 + 3 == 6) {
            int nodeCount = que.size();
            if (nodeCount == 0) {
                return height;
            }
            height++;

            while (nodeCount > 0) {
                BinNode newnode = que.peek();
                que.remove();
                if (newnode.getLeft() != null) {
                    que.add(newnode.getLeft());
                }
                if (newnode.getRight() != null) {
                    que.add(newnode.getRight());
                }
                nodeCount--;
            }
        }
    }

    public int rangeOfTree() {
        //return the max of the tree - min of the tree
        if (root == null) {
            return -1;
        }
        int max = -1;
        int min = 9999;
        Stack<BinNode> s = new Stack<BinNode>();
        BinNode current = root;
        int sum = 0;
        while (current != null || s.size() > 0) {

            while (current != null) {
                s.push(current);
                current = current.getLeft();
            }

            current = s.pop();

            if (current.getData() < min) {
                min = current.getData();
            }
            if (current.getData() > max) {
                max = current.getData();
            }
            current = current.getRight();
        }

        int range = max - min;
        return range;
    }

    public BinNode smallestNode() {
        //returns the smallest node in the tree
        //return the max of the tree - min of the tree
        if (root == null) {
            return null;
        }
        BinNode bn = null;
        int min = 9999;
        Stack<BinNode> s = new Stack<BinNode>();
        BinNode curr = root;
        while (curr != null || s.size() > 0) {

            while (curr != null) {
                s.push(curr);
                curr = curr.getLeft();
            }
            curr = s.pop();
            if (curr.getData() < min) {
                min = curr.getData();
                bn = curr;
            }
            curr = curr.getRight();
        }
        return bn;
    }

    public BinNode largestNode() {
        //returns the largest node in the tree
        if (root == null) {
            return null;
        }
        BinNode bn = null;
        int max = -99;
        Stack<BinNode> s = new Stack<BinNode>();
        BinNode current = root;
        while (current != null || s.size() > 0) {
            while (current != null) {
                s.push(current);
                current = current.getLeft();
            }
            current = s.pop();
            if (current.getData() > max) {
                max = current.getData();
                bn = current;
            }
            current = current.getRight();
        }
        return bn;
    }

    public int averageOfTree() {
        //returns the average of the tree
        if (root == null) {
            return -1;
        }
        Stack<BinNode> s = new Stack<BinNode>();
        BinNode curr = root;
        int sum = 0;
        int num = 0;
        while (curr != null || s.size() > 0) {
            while (curr != null) {
                s.push(curr);
                curr = curr.getLeft();
            }
            curr = s.pop();
            num++;
            sum = sum + curr.getData();
            curr = curr.getRight();
        }

        int Avg = sum / num;
        return Avg;
    }

    public int numNodes() {
        //returns the number of nodes in the tress
        if (root == null) {
            return -1;
        }
        Stack<BinNode> s = new Stack<BinNode>();
        BinNode current = root;
        int num = 0;
        while (current != null || s.size() > 0) {

            while (current != null) {
                s.push(current);
                current = current.getLeft();
            }

            current = s.pop();

            num++;

            current = current.getRight();
        }
        return num;
    }

    public String toString() {
        Queue<Integer> treeList = toString(root, new LinkedList<Integer>());
        StringBuilder builder = new StringBuilder();
        int level = 0;

        while (treeList.size() > 0) {
            int numNodesToProcess = (int) Math.pow(2, level);
            builder.append("Level " + level + ": ");
            for (int i = 0; i < numNodesToProcess; i++) {
                builder.append(treeList.poll() + " ");
            }
            builder.append("\n");
            level++;
        }

        return builder.toString();
    }

    private Queue<Integer> toString(BinNode root, Queue<Integer> list) {
        if (root == null) {
            return list;
        }
        int numNodesAdded = 0;
        Queue<BinNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            BinNode current = queue.poll();
            if (current != null) {
                list.add(current.getData());
                queue.add(current.getLeft());
                queue.add(current.getRight());
                numNodesAdded++;
            } else {
                list.add(null);
                queue.add(null);
                queue.add(null);
            }

            if (numNodesAdded == size) {
                break;
            }
        }
        return list;

    }

    private BinNode findEmptyLeftChild(BinNode root) {
        if (root.getLeft() == null) {
            return root;
        }
        if (root.getRight() == null) {
            return findEmptyLeftChild(root.getLeft());
        }
        final Random rng = new Random();
        final int rand = rng.nextInt();
        return rand % 2 == 0 ? findEmptyLeftChild(root.getLeft()) : findEmptyLeftChild(root.getRight());
    }

    private BinNode findEmptyRightChild(BinNode root) {
        if (root.getRight() == null) {
            return root;
        }
        if (root.getLeft() == null) {
            return findEmptyRightChild(root.getRight());
        }
        final Random rng = new Random();
        final int rand = rng.nextInt();
        return rand % 2 == 0 ? findEmptyRightChild(root.getLeft()) : findEmptyRightChild(root.getRight());
    }

}
