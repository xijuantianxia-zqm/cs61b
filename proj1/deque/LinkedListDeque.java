package deque;

public class LinkedListDeque<anytype> {
    private final Node<anytype> head = new Node<>(null,null,null);
    private int size;
    private static class Node<N>{
        private Node<N> prev;
        private final N item;
        private Node<N> next;

        public Node(N i,Node p,Node n){
            item = i;
            prev = p;
            next = n;
        }

    }

    public LinkedListDeque(){
        head.prev = head;
        head.next = head;
        size = 0;
    }

    public LinkedListDeque(anytype item){
        head.next = new Node<>(item,head,head);
        head.prev = head.next;
        size = 1;
    }

    public void addFirst(anytype i){
        head.next = new Node<anytype>(i,head,head.next);
        head.next.next.prev = head.next;
        size++;
    }

    public void addLast(anytype i){
        head.prev = new Node<>(i,head.prev,head);
        head.prev.prev.next = head.prev;
        size++;
    }

    public anytype removeFirst(){
        if(isEmpty()){
            return null;
        }

        anytype item = head.next.item;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return item;
    }

    public anytype removeLast(){
        if(isEmpty()){
            return null;
        }

        anytype item = head.prev.item;
        head.prev = head.prev.prev;
        head.prev.next = head;
        size--;
        return item;
    }

    public anytype get(int index){
        if(index < 0 || index > size - 1){
            return null;
        }
        Node<anytype> currentNode = head.next;
        int i = 0;
        while(i < index){
            currentNode = currentNode.next;
            i++;
        }
        return currentNode.item;

    }

    public anytype getRecursive(int index){
        if(index < 0 || index > size - 1){
            return null;
        }
        return getRecursive(index,head.next);
    }

    public anytype getRecursive(int index,Node<anytype> currentNode){
        if(index == 0){
            return currentNode.item;
        }
        return getRecursive(index - 1,currentNode.next);
    }

    public int size(){
        return size;
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public void printDeque(){
        Node<anytype> currentNode = head.next;
        while(currentNode.next != head){
            System.out.print(currentNode.item);
            System.out.print(' ');
            currentNode = currentNode.next;
        }
        System.out.println(currentNode.item);
    }





}
