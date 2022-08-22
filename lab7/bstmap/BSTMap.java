package bstmap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K,V>{
    private BSTnode root;
    private int size = 0;
    private class BSTnode{
        public K key;
        public V value;
        public BSTnode left;
        public BSTnode right;

        private int size;
        public BSTnode(K key,V value){
            this.key = key;
            this.value = value;
        }
    }




    public void printInOrder(){
        printInOrder(root);
    }
    public void printInOrder(BSTnode node){
        if(node == null) return;
        printInOrder(node.left);
        System.out.println(node.key.toString() + " -> " + node.value.toString());
        printInOrder(node.right);
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {

        return containsKey(key,root);
    }

    public boolean containsKey(K key,BSTnode node){
        if(node == null) return false;

        if(key.equals(node.key)) return true;
        if(key.compareTo(node.key) < 0) return containsKey(key,node.left);
        else return containsKey(key,node.right);

    }


    @Override
    public V get(K key) {
        return get(key,root);
    }

    public V get(K key,BSTnode node){
        if(node == null) return null;

        int cmp = key.compareTo(node.key);

        if(cmp < 0) return get(key,node.left);
        else if(cmp > 0) return get(key,node.right);

        return node.value;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {

        root = put(key,value,root);
        size++;
    }

    public BSTnode put(K key, V value, BSTnode node){
        if(node == null) return new BSTnode(key,value);

        int cmp = key.compareTo(node.key);

        if(cmp < 0) node.left = put(key,value,node.left);
        else if(cmp > 0) node.right = put(key,value,node.right);
        else node.value = value;

        return node;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();

        keySetHelper(keySet,root);
        return keySet;
    }

    public void keySetHelper(Set<K> keySet,BSTnode node){

        if(node == null) return;

        keySet.add(node.key);
        keySetHelper(keySet,node.left);
        keySetHelper(keySet,node.right);
    }


    @Override
    public V remove(K key) {
        if(!containsKey(key)) return null;

        V value = get(key);
        root = remove(root,key);
        size--;
        return value;
    }

    private BSTnode remove(BSTnode node, K key) {
        if(node == null) return null;

        int cmp = key.compareTo(node.key);
        if(cmp < 0) node.left = remove(node.left,key);
        else if(cmp > 0) node.right = remove(node.right,key);
        else {
            if(node.left == null) return node.right;
            if(node.right == null) return node.left;

            BSTnode curNode = node;
            node = getMinNode(curNode.right);
            node.left = curNode.left;
            node.right = remove(curNode.right,node.key);
        }
        return node;
    }

    private BSTnode getMinNode(BSTnode curNode) {
        if(curNode.left == null) return curNode;
        return getMinNode(curNode.left);
    }

    @Override
    public V remove(K key, V value) {

        if(containsKey(key)){

            V val = get(key);
            if(val.equals(value)) {
                root = remove(root, key);
                size--;
                return val;
            }
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }
}
