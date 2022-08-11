package deque;


import java.util.Deque;
import java.util.Iterator;

public class LinkedListDeque<T> implements deque.Deque<T> {
    private final Node<T> head = new Node<>(null, null, null);
    private int size;

    private static class Node<N> {
        private Node<N> prev;
        private final N item;
        private Node<N> next;

        public Node(N i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }

    }

    public LinkedListDeque() {
        head.prev = head;
        head.next = head;
        size = 0;
    }

    public LinkedListDeque(T item) {
        head.next = new Node<>(item, head, head);
        head.prev = head.next;
        size = 1;
    }

    @Override
    public void addFirst(T i) {
        head.next = new Node<T>(i, head, head.next);
        head.next.next.prev = head.next;
        size++;
    }

    @Override
    public void addLast(T i) {
        head.prev = new Node<>(i, head.prev, head);
        head.prev.prev.next = head.prev;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T item = head.next.item;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return item;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T item = head.prev.item;
        head.prev = head.prev.prev;
        head.prev.next = head;
        size--;
        return item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        Node<T> currentNode = head.next;
        int i = 0;
        while (i < index) {
            currentNode = currentNode.next;
            i++;
        }
        return currentNode.item;

    }

    public T getRecursive(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        return getRecursive(index, head.next);
    }

    public T getRecursive(int index, Node<T> currentNode) {
        if (index == 0) {
            return currentNode.item;
        }
        return getRecursive(index - 1, currentNode.next);
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public void printDeque() {
        Node<T> currentNode = head.next;
        while (currentNode.next != head) {
            System.out.print(currentNode.item);
            System.out.print(' ');
            currentNode = currentNode.next;
        }
        System.out.println(currentNode.item);
    }

    public Iterator<T> iterator() {
        return new LinkedIterator();
    }


    public class LinkedIterator implements Iterator<T> {
        private Node cur;

        public LinkedIterator() {
            cur = head.next;
        }

        @Override
        public boolean hasNext() {
            return cur != head;
        }

        @Override
        public T next() {
            T item = (T) cur.item;
            cur = cur.next;
            return item;
        }
    }

    public boolean equals(Object o) {
        if (!(o instanceof Deque)) return false;
        LinkedListDeque other = (LinkedListDeque) o;
        if (size != other.size()) return false;

        Node p = head.next;
        for (int i = 0; i < size; i++) {
            if (!p.item.equals(other.get(i))) {
                return false;
            }
            p = p.next;
        }
        return false;

    }
}
