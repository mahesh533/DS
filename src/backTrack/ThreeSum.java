package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 *
 */

public class ThreeSum {

    List<List<Integer>> glist=new ArrayList<List<Integer>>();

    public static void main(String[] args) {


        for(List<Integer> a: new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1})){
            System.out.println(a);
        }

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        backTrack(nums,0,0,new ArrayList<Integer>(), 0);
        return  glist;

    }

    public void backTrack(int[] nums,int sum,int numberOfElems,List<Integer> list,int start){

        if(numberOfElems == 3 && sum == 0){
            glist.add(new ArrayList<Integer>(list));

        }else if(numberOfElems >= 3){
            return;
        }else if(start >=nums.length){
            return;
        }else{


                int present=nums[start];
                list.add(present);
                backTrack(nums,sum+present,numberOfElems+1,list, start+1);
                list.remove(list.size()-1);
                while (start > nums.length-1 && nums[start] ==  nums[start+1]){
                    start++;
                }
                backTrack(nums,sum,numberOfElems,list, start+1);







        }



    }
}
