package Discussion3;

public class SLlist <T>{
    private int size;
    public SLlist(T i) {
        first = new IntNode(i,null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int maxIndex) {
        IntNode res = null;
        if(maxIndex < 0 || maxIndex > size) return null;
        for (int i = 0;i <= maxIndex;i++){
            res = first.next;
        }
        return (T) res.item;
    }

    private class IntNode<T>{
        public T item;
        public IntNode next;
        public IntNode(T item,IntNode next){
            item = item;
            next = next;
        }
    }

    private IntNode first;
    public void addFirst(T x){
        first = new IntNode(x,first);
        size++;
    }

    public void insert(T item,int position){
        if(first == null || position == 0) {
            addFirst(item);
            return;
        }
        int cur = 0;
        IntNode currentNode = first;
        while(cur < position && currentNode.next != null) {
            currentNode = currentNode.next;
            cur++;
        }
        IntNode node = new IntNode(item,currentNode.next);
        currentNode.next = node;
        size++;
    }
    public void reverse(){
        if(first == null || first.next == null){
            return;
        }
        IntNode ptr = first.next;
        first.next = null;

        while (ptr != null){
            IntNode temp = ptr.next;
            ptr.next = first;
            first = ptr;
            ptr = temp;
        }
    }

    public void reverseRecursive(){
        first = reverseRecursive(first);
    }
    public IntNode reverseRecursive(IntNode node){
        if(node == null || node.next == null){
            return node;
        }else{
            IntNode endOfReversed = node.next;
            IntNode reversed = reverseRecursive(node.next);
            endOfReversed = node;
            node.next = null;
            return reversed;
        }

    }
}
