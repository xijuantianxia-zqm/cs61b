package randomizedtest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> noResizing = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();

        noResizing.addLast(4);
        buggyAList.addLast(4);
        noResizing.addLast(5);
        buggyAList.addLast(5);
        buggyAList.addLast(6);
        noResizing.addLast(6);

        Integer x = noResizing.removeLast();
        Integer y = buggyAList.removeLast();
        assertEquals(x,y);

        Integer x1 = noResizing.removeLast();
        Integer y1 = buggyAList.removeLast();
        assertEquals(x1,y1);

        Integer x2 = noResizing.removeLast();
        Integer y2 = buggyAList.removeLast();
        assertEquals(x2,y2);

    }

    @Test
    public void randomizedTest() {
        BuggyAList<Integer> broken = new BuggyAList<>();
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            }else if(operationNumber == 2 && correct.size() > 0){
                // getLasst
                int val = correct.getLast();
                assertEquals(correct.getLast(),broken.getLast());
                System.out.println("getLast" + val);
            }else if(operationNumber == 3 && correct.size() > 0){
                int val = correct.removeLast();
                assertEquals(val,(int)broken.removeLast());
                System.out.println("removeLast:" + val);
            }else{
                // size
                int size = correct.size();
                assertEquals(size,broken.size());
                System.out.println("size: " + size);
            }
        }
    }

}
