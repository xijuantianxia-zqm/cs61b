package DIY;

import Discussion3.SLlist;

public class WordUtils {

    public static String longest(SLlist<String> list){
        int maxIndex = 0;
        for(int i = 0;i < list.size();i++){
            String longestString = list.get(maxIndex);
            String thisString = list.get(i);
            if(longestString.length() < thisString.length()){
                maxIndex = i;
            }
        }
        return list.get(maxIndex);
    }
}
