package Map61B;

import java.util.ArrayList;
import java.util.List;

public class ArrayMap <K,V>  {
    private K[] keys;
    private V[] values;
    int size;

    public ArrayMap() {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    public int keyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public void put(K key, V value) {
        int index = keyIndex(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    public boolean containsKey(K key) {
        int index = keyIndex(key);
        return index > -1;
    }

    public V get(K key) {
        int index = keyIndex(key);
        return values[index];

    }
    public List<K> keys(){
        List<K> keyList = new ArrayList<>();
        for(int i = 0;i < size;i++){
            keyList.add(keys[i]);
        }
        return keyList;
    }
}
