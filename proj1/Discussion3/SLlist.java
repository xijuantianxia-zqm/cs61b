package Discussion3;

public class SLlist {

    public SLlist(int i) {
        first = new IntNode(i,null);
    }

    private class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int item,IntNode next){
            item = item;
            next = next;
        }
    }

    private IntNode first;
    public void addFirst(int x){
        first = new IntNode(x,first);
    }

    public void insert(int item,int position){
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
