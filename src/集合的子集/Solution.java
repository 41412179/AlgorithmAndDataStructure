package 集合的子集;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by h on 16-12-19.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
        // write code here
        Arrays.sort(A,
                0, n);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> one = new ArrayList<Integer>();
        one.add(A[0]);
        res.add(one);
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for (int i = 1; i < n; i++) {
            int size = res.size();
            //tmp.clear();
            for (int j = 0; j < size; j++) {
                tmp = new ArrayList<Integer>();
                for(Integer k :res.get(j)){
                    tmp.add(k);
                }
                tmp.add(A[i]);
                res.add(tmp);
            }
            tmp = new ArrayList<Integer>();
            tmp.add(A[i]);
            res.add(tmp);
        }
//        for(int i = 0; i<res.size();i++){
//            tmp = res.get(i);
//            for(int j = 0 ;j<tmp.size();j++){
//                System.out.print(tmp.get(j) + " ");
//            }
//            System.out.println();
//        }
        for (int i = 0;i<res.size();i++) {
            tmp = res.get(i);
            Collections.sort(tmp, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int len = Math.min(a.size(), b.size());
                //boolean flag = false;
                for(int i = 0;i<len;i++){
                    if(a.get(i) < b.get(i)){
                        return 1;
                    } else {
                        if(a.get(i) > b.get(i)){
                            return -1;
                        }
                    }
                }
                return b.size() - a.size();
            }
        });
//        System.out.println("---------");
//        for(int i = 0; i<res.size();i++){
//            tmp = res.get(i);
//            for(int j = 0 ;j<tmp.size();j++){
//                System.out.print(tmp.get(j) + " ");
//            }
//            System.out.println();
//        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3};
        int n = A.length;
        new Solution().getSubsets(A, n);
    }
}
