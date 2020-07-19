package ge.george.linkedlist;

public class Node<K> {
    private Node<K> prev;
    private Node<K> next;
    private K key;
    public Node(){}
    public Node(K key){
        setKey(key);
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setNext(Node<K> next) {
        this.next = next;
    }

    public void setPrev(Node<K> prev) {
        this.prev = prev;
    }

    public K getKey() {
        return key;
    }

    public Node<K> getNext() {
        return next;
    }

    public Node<K> getPrev() {
        return prev;
    }
}

