package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{

    private Comparator comparator;

    public MaxArrayDeque(Comparator<T> C){
        capacity = 8;
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        comparator = C;
    }

    public T max(){
        if(size == 0) return null;
        int index = addOne(nextFirst);
        T max = items[index];
        for(int i = 0;i < size;i++){
            if(comparator.compare(items[index],max) > 0){
                max = items[index];
            }
            index = addOne(index);
        }
        return max;
    }

    public T max(Comparator<T> C){
        if(size == 0) return null;
        int index = addOne(nextFirst);
        T max = items[index];
        for(int i = 0;i < size;i++){
            if(C.compare(items[index],max) > 0){
                max = items[index];
            }
            index = addOne(index);
        }
        return max;
    }
}
