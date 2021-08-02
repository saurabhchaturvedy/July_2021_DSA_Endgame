package BinarySearchTree.Till20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BST {


    private class Node {
        int data;
        Node left;
        Node right;
    }


    private Node insert(Node node, int val) {
        if (node == null) {
            return createNewNode(val);
        }

        if (val < node.data) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }

        return node;
    }

    private Node createNewNode(int val) {

        Node node = new Node();
        node.data = val;
        node.left = null;
        node.right = null;
        return node;
    }


    private static Node delete(Node node, int val) {

        if (node == null) {
            return null;
        }

        if (val < node.data) {
            node.left = delete(node.left, val);
        } else if (val > node.data) {
            node.right = delete(node.right, val);
        } else {
            if (node.left == null || node.right == null) {
                Node temp = null;
                temp = node.left == null ? node.right : node.left;

                return temp;
            } else {
                Node successor = getSuccessor(node);
                node.data = successor.data;
                node.right = delete(node.right, successor.data);
                return node;
            }
        }

        return node;
    }


    private boolean search(Node node, int val) {
        if (node == null) {
            return false;
        }


        boolean isFound = false;

        while (node != null) {

            if (val < node.data) {
                return search(node.left, val);
            } else if (val > node.data) {
                return search(node.right, val);
            } else {
                isFound = true;
                break;
            }
        }

        return isFound;
    }


    private static Node getSibling(Node node, int val) {
        if (node == null) {
            return null;
        }

        Node parent = null;

        while (node != null) {

            if (val < node.data) {
                parent = node;
                node = node.left;
                node.left = getSibling(node.left, val);
            } else if (val > node.data) {
                parent = node;
                node = node.right;
                node.right = getSibling(node.right, val);

            } else {
                break;
            }
        }


        if (parent != null && val == parent.left.data) {
            return parent.right;
        }

        if (parent != null && val == parent.right.data) {
            return parent.left;
        }

        return parent;

    }

    private static Node getSuccessor(Node node) {
        if (node == null) {
            return null;
        }

        Node temp = node.right;

        while (temp.left != null) {

            temp = temp.left;
        }

        return temp;
    }


    private static int getMax(Node node) {
        if (node == null) {
            System.out.println("tree is empty");
            return -1;
        }

        if (node.right != null) {
            node = node.right;
        }

        return node.data;
    }

    private static int getMin(Node node) {
        if (node == null) {
            System.out.println("tree is empty");
            return -1;
        }

        if (node.left != null) {
            node = node.left;
        }

        return node.data;
    }


    private static boolean ifPairExists(Node node, int sum, Set<Integer> set) {
        if (node == null) {
            return false;
        }

        if (set.contains(sum - node.data)) {
            return true;
        }

        set.add(node.data);

        if (!ifPairExists(node.left, sum, set)) {
            return false;
        }

        return ifPairExists(node.right, sum, set);
    }


    private static void printBST(Node node) {
        if (node == null)
            return;

        printBST(node.left);
        System.out.print(node.data + " ");
        printBST(node.right);
    }

    private static void printBSTPreOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        printBST(node.left);
        printBST(node.right);
    }


    private static void printBSTPostOrder(Node node) {
        if (node == null)
            return;


        printBST(node.left);
        printBST(node.right);
        System.out.print(node.data + " ");
    }


    private static Node getParentNode(Node node, int val) {
        if (node == null) {
            return null;
        }

        Node parentNode = null;
        boolean isNodeExists = false;

        while (node != null) {

            if (val < node.data) {
                parentNode = node;
                node = node.left;
                node.left = getParentNode(node.left, val);
            } else if (val > node.data) {
                parentNode = node;
                node = node.right;
                node.right = getParentNode(node.right, val);
            } else {
                isNodeExists = true;
                break;
            }

        }

        return isNodeExists ? parentNode : null;
    }


    private static boolean doesTripletExists(Node node, int sum) {
        List<Integer> integerList = new ArrayList<>();
        inorder(node, integerList);
        return checkIfTripletExists(integerList, sum);
    }

    private static boolean checkIfTripletExists(List<Integer> integerList, int sum) {

        int size = integerList.size();
        int currentSum = 0;

        for (int i = 0; i < size - 2; i++) {

            int j = i + 1;
            int k = size - 1;

            while (j < k) {
                currentSum = integerList.get(i) + integerList.get(j) + integerList.get(k);

                if (currentSum == sum) {
                    return true;
                } else if (currentSum < sum) {
                    i++;
                } else {
                    j--;
                }

            }
        }

        return false;
    }

    private static void inorder(Node node, List<Integer> integerList) {
        if (node == null) {
            return;
        }

        inorder(node.left, integerList);
        integerList.add(node.data);
        inorder(node.right, integerList);
    }


    private static int getEvenOddNodes(Node node) {
        if (node == null) return 0;

        return node.data - getEvenOddNodes(node.left) - getEvenOddNodes(node.right);

    }


    public static void main(String[] args) {
        BST bst = new BST();
        Node root = null;


        root = bst.insert(root, 5);
        root = bst.insert(root, 8);
        root = bst.insert(root, 3);
        // root = bst.delete(root, 3);


        printBST(root);

        System.out.println(bst.search(root, 8));
        System.out.println("parent node " + getParentNode(root, 8).data);
        System.out.println(getSibling(root, 3).data);
        System.out.println(getMax(root));
        System.out.println(getMin(root));
        Set<Integer> integers = new HashSet<>();
        System.out.println(ifPairExists(root, 10, integers));
    }
}
