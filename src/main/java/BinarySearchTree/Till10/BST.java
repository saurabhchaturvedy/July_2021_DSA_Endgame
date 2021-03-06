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


    private static Node getInorderParent(Node node, int val) {
        if (node == null) {
            return null;
        }

        Node inorderParent = null;

        while (node != null) {
            if (val < node.data) {
                inorderParent = node;
                node = node.left;
            } else if (val > node.data) {
                node = node.right;
            } else {
                break;
            }
        }


        return node != null ? inorderParent : null;
    }


    private static Node getInorderSuccessor(Node node, int val) {

        if (node == null) {
            return null;
        }

        Node inorderSuccessor = null;

        while (node != null) {

            if (val < node.data) {
                inorderSuccessor = node;
                node = node.left;
            } else if (val > node.data) {
                node = node.right;
            } else {

                if (node.right != null) {
                    inorderSuccessor = getSuccessor(node);
                }

                break;
            }
        }

        return node != null ? inorderSuccessor : null;
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
    }
}
