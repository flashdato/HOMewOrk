package ge.george.binarytree;

public class Node<V> {
    private V value;
    private Node<V> left;
    private Node<V> right;
    private Node<V> predecessor;

    public Node() {
    }

    public Node(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<V> getLeft() {
        return left;
    }

    public void setLeft(Node<V> left) {
        this.left = left;
    }

    public Node<V> getRight() {
        return right;
    }

    public void setRight(Node<V> right) {
        this.right = right;
    }

    public Node<V> getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Node<V> predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public String toString() {
        if(left==null && right == null ){
            return value.toString();
        }
        if(left==null ) {
            return value+ "\n  r = " + right  ;
        }
        if(right==null ) {
            return value + "\n l = " + left ;
        }
        return value + "\n l = " + left + " r = "+ right;
    }
}
