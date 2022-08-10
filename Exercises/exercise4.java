import jh61b.junit.In;

import java.util.*;

public class exercise4 {
    public static List<String> getWords(String inputFileName){
        List<String> lst = new ArrayList<>();
        In in = new In();
        while (!in.isEmpty()){
            lst.add(in.readString());
        }
        return lst;
    }

    public static int countUniqueWords(List<String> input){
        Set<String> ss = new HashSet<>();
        for(String s:ss){
            ss.add(s);
        }
        return ss.size();
    }

    public static Map<String, Integer> collectWordCount(List<String> targets,List<String> words){
        Map<String,Integer> res = new HashMap<>();
        for(String s:targets){
            res.put(s,0);
        }

        for(String s:words){
            if(res.containsKey(s)){
                res.put(s,res.get(s) + 1);
            }
        }
        return res;
    }
}
