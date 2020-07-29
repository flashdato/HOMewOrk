package ge.george.binarytree;

import java.util.Optional;

public class BinarySearchTree<V extends Comparable<V>> {
    private Node<V> root;

    public void insert(V value) {
        Node<V> y = null;
        Node<V> x = root;
        Node<V> z = new Node<>(value);

        while (x != null) {
            y = x;
            x = 0 > value.compareTo(x.getValue()) ? x.getLeft() : x.getRight();

        }
        z.setPredecessor(y);
        if (y == null) {
            root = z;
        } else if (0 > value.compareTo(y.getValue())) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }

    }
    public Optional<V> minimum() {
        Node<V> x = root;
        if (root == null) return Optional.empty();
        while (x.getLeft() != null) {
            x = x.getLeft();
        }
        return Optional.of(x.getValue());
    }
    public Optional<V> maximum() {
        Node<V> x = root;
        if (root == null) return Optional.empty();
        while (x.getRight() != null) {
            x = x.getRight();
        }
        return Optional.of(x.getValue());
    }
    public boolean contains(V value) {
        Node<V> x = root;
        while (x != null) {
            int c = x.getValue().compareTo(value);
            if (c == 0) return true;
            x = 0 > c ? x.getRight() : x.getLeft();
        }
        return false;
    }
    public Optional<V> successor(V value) {
        Node<V> x = new Node<>(value);
        if (x.getRight() != null) {
            return minimum();
        }
        Node<V> y = x.getPredecessor();
        while (y != null && x == y.getRight()) {
            x = y;
            y = y.getPredecessor();
        }
        return Optional.of(y.getValue());
    }

    @Override
    public String toString() {
        return root == null ? "null" : root.toString();
    }
}
