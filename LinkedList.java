package ge.george.linkedlist;
import java.util.Optional;

public class LinkedList<K> {
    private Node<K> head;
    private Node<K> tail;
    public long length(){
       Node<K> temp=head;
        if (head == null)
            return 0;
       long counter=1;
       while (temp.getNext() != null) {
           temp=temp.getNext();
           counter++;
       }
       return counter;
   }
    public boolean isEmpty(){return head==null;}
    public Node<K> insert(K key) {
        if (head == null) {
            head = new Node<>(key);
            tail = head;
        } else {
            Node<K> temp = new Node<>(key);
            temp.setNext(head);
            this.head.setPrev(temp);
            this.head = temp;
        }
        return head;
    }
    public Optional<Node<K>> insertByIndex(K key,int index) {
        if (head == null) return Optional.empty();;
        Node<K> indexnode = head;
        for (int i = 0; i < index; i++) {
            indexnode=indexnode.getNext();
        }
        Node<K> temp = new Node<>(key);
        indexnode.getPrev().setNext(temp);
        temp.setPrev(indexnode.getPrev());
        temp.setNext(indexnode);
        indexnode.setPrev(temp);
        return Optional.of(temp);

    }
    public boolean delete(K key) {
        Optional<Node<K>> search = search(key);
        if (search.isEmpty()) {
            return false;
        }
        Node<K> next = search.get().getNext();
        Node<K> prev = search.get().getPrev();
        if (prev != null) {
            prev.setNext(next);
        }
        if (next != null) {
            next.setPrev(prev);
        }
        return true;
    }
    public Optional<Node<K>> search(K key) {
        if (head == null) {
            return Optional.empty();
        }
        Node<K> temp = head;
        while (temp.getNext() != null) {
            if (temp.getKey().equals(key)) {
                break;
            }
            temp = temp.getNext();
        }
        if (!temp.getKey().equals(key)) {
            return Optional.empty();
        }
        return Optional.of(temp);
    }
    public Optional<Node<K>> searchByIndex(int index) {
        if (head == null) return Optional.empty();;
        Node<K> indexnode = head;
        for (int i = 0; i < index; i++) {
            indexnode=indexnode.getNext();
        }
        return Optional.of(indexnode);
    }
    public Optional<Node<K>> removeByIndex(int index) {
        Node<K> indexnode = head;
        if(indexnode == null) return Optional.empty();
        if (index==0) return removeFirst();
        if (index==length()-1) return removeLast();
        for (int i = 0; i < index; i++) {
            indexnode=indexnode.getNext();
        }

        indexnode.getNext().setPrev(indexnode.getPrev());
        indexnode.getPrev().setNext(indexnode.getNext());
        return Optional.of(indexnode);
    }
    public Optional<Node<K>> removeLast() {
        Node<K> temp = tail;
        if (temp == null) return Optional.empty();;
        if (temp == head) {
            tail = null;
            head = null;
            return Optional.of(temp);
        }
        tail = tail.getPrev();
        tail.setNext(null);
        temp.setPrev(null);
        return  Optional.of(temp);
    }
    public Optional<Node<K>> removeFirst(){
        Node<K> temp = head;
        if(temp == null) return Optional.empty();
        if (temp == tail) {
            tail = null;
            head = null;
            return Optional.of(temp);
        }
        head = head.getNext();
        head.setPrev(null);
        temp.setNext(null);
        return Optional.of(temp);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LinkedList{");
        Node<K> temp = head;
        while (temp != null) {
            sb.append(temp.getKey()).append(", ");
            temp = temp.getNext();
        }
        if(sb.indexOf(",")>0){
            sb.setLength(sb.length()-2);
        }
        sb.append("}");
        return sb.toString();
    }
}