package BinarySearchTree.Till10;

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


    public static void main(String[] args) {
        BST bst = new BST();
        Node root = null;


        root = bst.insert(root, 5);
        root = bst.insert(root, 8);
        root = bst.insert(root, 3);
        root = bst.delete(root, 3);


        printBST(root);

        System.out.println(bst.search(root,8));
    }
}
