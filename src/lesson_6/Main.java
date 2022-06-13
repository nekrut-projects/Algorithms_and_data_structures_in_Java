package lesson_6;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        int amountTrees = 200;

        System.out.printf("out of %d trees - %.2f%% are balanced", amountTrees, checkBalance(amountTrees));

    }

    public static boolean isBalancedTree(Tree tree) {
        if (tree.root == null) {
            return false;
        }

        LinkedList<Tree.TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        Tree.TreeNode currNode = null;

        depths.add(1);
        stack.add(tree.root);
        int minDepth = 0, maxDepth = 0;

        while (!stack.isEmpty()){
            currNode = stack.pollLast();
            int currDepth = depths.pollLast();
            if (currNode != null){
                maxDepth = Math.max(maxDepth, currDepth);
                if (currNode.leftChild == null && currNode.rightChild == null) {
                    if (minDepth == 0 || currDepth < minDepth){
                        minDepth = currDepth;
                    }
                }
                stack.add(currNode.leftChild);
                depths.add(currDepth + 1);
                stack.add(currNode.rightChild);
                depths.add(currDepth + 1);
            }
        }
        return maxDepth - minDepth <= 1;
    }

    public static double checkBalance(int amountTrees) {
        Tree[] trees = new Tree[amountTrees];

        for (int i = 0; i < amountTrees; i++) {
            trees[i] = new Tree();
            for (int j = 0; j < 15; j++) {
                trees[i].insert(new Cat("Cat_" + j, (int)(Math.random() * 100 * j)));
            }
        }

        int count = 0;

        for (int i = 0; i < trees.length; i++) {
            if (isBalancedTree(trees[i])){
                ++count;
            }
        }
        return amountTrees * 0.01 * count;
    }


    public static class Tree {
        public class TreeNode {
            private Cat cat;
            public Tree.TreeNode leftChild;
            public Tree.TreeNode rightChild;

            public TreeNode(Cat cat) {
                this.cat = cat;
            }

            @Override
            public String toString() {
                return String.format("TN(%s)", cat);
            }
        }

        private Tree.TreeNode root;

        public Tree() {
            root = null;
        }

        public void insert(Cat c) {
            TreeNode node = new TreeNode(c);
            if (root == null) {
                root = node;
            } else {
                TreeNode current = root;
                TreeNode parent;
                while (true) {
                    parent = current;
                    if (c.age < current.cat.age) {
                        current = current.leftChild;
                        if (current == null) {
                            parent.leftChild = node;
                            return;
                        }
                    } else if (c.age > current.cat.age) {
                        current = current.rightChild;
                        if (current == null) {
                            parent.rightChild = node;
                            return;
                        }
                    } else {
                        return;
                    }
                }

            }
        }

        public Cat find(int age) {
            TreeNode current = root;
            while (current.cat.age != age) {
                if (age < current.cat.age)
                    current = current.leftChild;
                else
                    current = current.rightChild;

                if (current == null)
                    return null;
            }
            return current.cat;
        }

        private void inOrderTravers(TreeNode current) {
            if (current != null) {
                System.out.println(current);
                inOrderTravers(current.leftChild);
                inOrderTravers(current.rightChild);
            }
        }

        public void displayTree() {
            inOrderTravers(root);
        }

        public boolean delete(int age) {
            TreeNode curr = root;
            TreeNode prev = root;
            boolean isLeftChild = true;
            while (curr.cat.age != age) {
                prev = curr;
                if (age < curr.cat.age) {
                    isLeftChild = true;
                    curr = curr.leftChild;
                } else {
                    isLeftChild = false;
                    curr = curr.rightChild;
                }

                if (curr == null)
                    return false;
            }

            if (curr.leftChild == null && curr.rightChild == null) {
                if (curr == root) {
                    root = null;
                } else if (isLeftChild) {
                    prev.leftChild = null;
                } else {
                    prev.rightChild = null;
                }
            } else if (curr.rightChild == null) {
                if (isLeftChild) {
                    prev.leftChild = curr.leftChild;
                } else {
                    prev.rightChild = curr.leftChild;
                }
            } else if (curr.leftChild == null) {
                if (isLeftChild) {
                    prev.leftChild = curr.rightChild;
                } else {
                    prev.rightChild = curr.rightChild;
                }
            } else {
                TreeNode successor = getSuccessor(curr);
                if (curr == root) {
                    root = successor;
                } else if (isLeftChild) {
                    prev.leftChild = successor;
                } else {
                    prev.rightChild = successor;
                }
                successor.leftChild = curr.leftChild;
            }
            return true;
        }

        private TreeNode getSuccessor(TreeNode deleted) {
            TreeNode successorParent = deleted;
            TreeNode successor = deleted;
            TreeNode flag = deleted.rightChild;

            while (flag != null) {
                successorParent = successor;
                successor = flag;
                flag = flag.leftChild;
            }
            if (successor != deleted.rightChild) {
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = deleted.rightChild;
            }
            return successor;
        }


    }

}