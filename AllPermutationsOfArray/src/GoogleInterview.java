import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoogleInterview {

    public static void main(String[] args) {
        int[] a ={1,5,20,11,16};
        int[] b ={-1,0,4,2,1};
        int [] c =solution(3,b);

    }

    public static  int[] solution(int D, int[] A) {
        List<List<Integer>> listOfParents = new ArrayList<>();

        int[] result = new int[A.length];
        for(int i =0 ; i< A.length;i++){
            listOfParents.add(new ArrayList<>());
            int parent = A[i];
            for(int j= D-1;j>-1;j--){
                if(parent !=-1 && listOfParents.size()-1 > parent && listOfParents.get(parent)!=null && listOfParents.get(parent).size() > j){
                    parent = listOfParents.get(parent).get(j);
                    break;
                }
                listOfParents.get(i).add(parent);
                if(parent !=-1)
                parent = A[parent];
                else{
                    break;
                }
            }
            result[i] = parent;
        }
        return result;
    }

   /* public static int findParentAtD(int[] A, int parent, boolean[] noNeedToVisit, int D){
        if(A[parent] == -1 || noNeedToVisit[A[parent]]){
            noNeedToVisit[parent] = true;
            return -1;
        }
        if(D == 0){
            return parent;
        }

        return findParentAtD(A, A[parent], noNeedToVisit, D-1);
    }*/

    /*public static int[] solution(int[] stores, int[] houses) {
        int[] result  = new int[houses.length];
        for(int i =0; i< houses.length;i++){
            int sDTN = Integer.MAX_VALUE;
            int value = 0;
            for(int j=0; j< stores.length;j++){
                int diff = Math.abs(stores[j] - houses[i]);
                if(diff < sDTN){
                    sDTN =  diff;
                    value = stores[j];
                }
            }
            result[i] = value;
        }
        return result;
    }*/

    /*public static int[] solution(int[] stores, int[] houses) {
        Arrays.sort(stores);
        int[] result  = new int[houses.length];
        for(int i =0; i< houses.length;i++){
            findClosestShop(houses[i], stores);
        }
        return result;
    }

    private static int findClosestShop(int house, int[] stores) {

    }*/


}
