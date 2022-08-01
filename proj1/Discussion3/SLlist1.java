package Discussion3;

public class SLlist1 {
    Node sentinal;
    public SLlist1() {
        this.sentinal = new Node();
    }

    private static class Node{
        int item;
        Node next;
    }

    public int findFirst(int n){
        return findFirstHelper(n,0,sentinal.next);
    }

    public int findFirstHelper(int n,int index,Node curr){
        if(curr == null){
            return -1;
        }if(curr.item == n){
            return index;
        }else {
            return findFirstHelper(n,index+1,curr.next);
        }
    }
}
