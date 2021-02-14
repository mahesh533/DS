package backTrack;

import java.util.ArrayList;
import java.util.List;


public class CombinationSum {
    static List<List<Integer>> glist;


    public static void main(String[] args) {

        for(List<Integer> a: new CombinationSum().combinationSum(new int[]{2,3,6,7},7)){
            System.out.println(a);
        }

    }



    public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        glist=new ArrayList<List<Integer>>();
        backTrack(candidates,0,target,new ArrayList<Integer>(),0);
        return glist;


    }

    public  void backTrack(int[] candidates, int presentVal,int target,List<Integer> plist,int location){
         System.out.println("Start "+location+"\t Curr "+plist+"\t target "+target);

        if(target < 0){
            return;
        }else if(0 == target){
            glist.add(new ArrayList<Integer>(plist));
        } else {

            for (int i = location; i < candidates.length && target >= candidates[i]; i++) {

                int value = candidates[i];

                plist.add(value);
                backTrack(candidates, presentVal + value, target - value, plist, i+1);
                plist.remove(plist.size() - 1);

            }
        }

    }


}
