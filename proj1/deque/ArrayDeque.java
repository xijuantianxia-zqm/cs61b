package deque;


import java.util.Deque;
import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>{
    private T[] items;
    private int size;
    private int capacity;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        capacity = 8;
        items = (T[]) new Object[capacity];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public int addOne(int index){
        return (index + 1) % items.length;
    }

    public int minusOne(int index){
        return (index + items.length - 1) % items.length;
    }

    public void resize(int newCapacity){
        T[] newItem = (T[]) new Object[newCapacity];

        int curInd = addOne(nextFirst);
        for(int i = 0;i < size;i++){
            newItem[i] = items[curInd];
            curInd = addOne(curInd);
        }
        nextFirst = newCapacity - 1;
        nextLast = size;
        capacity = newCapacity;
        items = newItem;
    }

    public boolean isSmall(){
        return capacity >= 16 && size < capacity / 4;

    }
    public void addFirst(T item){
        if(isFull()){
            resize(capacity * 2);
        }

        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    public void addLast(T item){
        if (isFull()){
            resize(capacity * 2);
        }
        items[nextLast] = item;
        nextLast = addOne(nextLast);
        size++;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return size;
    }


    public T removeFirst(){
        if(size == 0) return null;

        if(isSmall()) resize((int) (0.5 * capacity));
        nextFirst = addOne(nextFirst);
        T item = items[nextFirst];
        items[nextFirst] = null;
        size--;

        return item;
    }

    public T removeLast(){
        if(size == 0) return null;

        nextLast = minusOne(nextLast);
        T item = items[nextLast];
        items[nextLast] = null;
        size--;
        if(isSmall()) resize((int) (0.5 * capacity));
        return item;
    }

    public T get(int index) {
        return items[(nextFirst + 1 + index) % items.length];
    }

    public void printDeque(){
        int index = (nextFirst + 1) % items.length;
        for(int i = 0;i < size;i++){
            System.out.print(items[index] + " ");
            index = (index + 1) % items.length;
        }
        System.out.println();
    }

    public Iterator<T> iterator(){
        return new ArrayDequeIterator();
    }

    public class ArrayDequeIterator implements Iterator<T>{
        private int cur;

        public ArrayDequeIterator(){
            cur = addOne(nextFirst);
        }
        @Override
        public boolean hasNext() {
            return cur != nextLast;
        }

        @Override
        public T next() {
            T returnItem = items[cur];
            cur = addOne(cur);
            return returnItem;
        }
    }

    public boolean equals(Object o){
        if(!(o instanceof Deque)){
            return false;
        }
        ArrayDeque other = (ArrayDeque)  o;
        if(size != other.size()) return false;

        int index = addOne(nextFirst);
        for(int i = 0;i < size;i++){
            if(!items[index].equals(other.get(i))){
                return false;
            }
            index = addOne(index);
        }
        return true;
    }

}
