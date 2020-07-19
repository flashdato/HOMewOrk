package ge.george.linkedlist;

import java.util.Optional;

public class Queue<K> {
    LinkedList<K> linkedList = new LinkedList<>();
    public void enqueue(K key) {
        linkedList.insert(key);
    }
    public Optional<K> dequeue() {
        Optional<Node<K>> last = linkedList.removeLast();
        return last.map(Node::getKey);
    }
    public Boolean isEmpty() {
        return linkedList.isEmpty();
    }


    @Override
    public String toString() {
        return linkedList.toString().replaceFirst("LinkedList", "Queue");
    }
}
