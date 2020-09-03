package JuneToAugust;

import java.util.ArrayList;

public class Algorithm {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        for(int i=1;i<=sum/2;i++){
            int tempSum=0;
            ArrayList<Integer>ansOne=new ArrayList<>();
            for(int j=i;j<sum;j++){
                tempSum+=j;
                ansOne.add(j);
                if(tempSum==sum){
                    ans.add(ansOne);
                    break;
                }
                if(tempSum>sum){
                    break;
                }
            }
        }
        return ans;

    }
}
