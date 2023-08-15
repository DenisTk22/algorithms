package practice4.hw4;
//Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево. И реализовать в нем метод добавления новых элементов с балансировкой.
public class RBTree {
    private Node root;

    public boolean add(int value) {
        if (root != null) {
            boolean result = addNode(root,value);
            root = rebalance(root);
            root.color = RBTree.Color.BLACK;
            return result;
        } else {
            root = new RBTree.Node();
            root.color = RBTree.Color.BLACK;
            root.value = value;
            return true;
        }
    }
    private boolean addNode(RBTree.Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new RBTree.Node();
                    node.leftChild.color = RBTree.Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new RBTree.Node();
                    node.rightChild.color = RBTree.Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }
    private RBTree.Node rebalance(RBTree.Node node) {
        RBTree.Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == RBTree.Color.RED &&
                    (result.leftChild == null || result.leftChild.color == RBTree.Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == RBTree.Color.RED &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == RBTree.Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == RBTree.Color.RED &&
                    result.rightChild != null && result.rightChild.color == RBTree.Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        }
        while (needRebalance);
        return result;
    }
    private RBTree.Node rightSwap(RBTree.Node node) {
        RBTree.Node rightChild = node.rightChild;
        RBTree.Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = RBTree.Color.RED;
        return rightChild;
    }
    private RBTree.Node leftSwap(RBTree.Node node) {
        RBTree.Node leftChild = node.leftChild;
        RBTree.Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = RBTree.Color.RED;
        return leftChild;
    }
    private void colorSwap(RBTree.Node node) {
        node.rightChild.color = RBTree.Color.BLACK;
        node.leftChild.color = RBTree.Color.BLACK;
        node.color = RBTree.Color.RED;
    }

    private class Node {
        private int value;
        private RBTree.Color color;
        private RBTree.Node leftChild;
        private RBTree.Node rightChild;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", color=" + color +
                    '}';
        }
    }

    private enum Color {
        RED, BLACK
    }
}
