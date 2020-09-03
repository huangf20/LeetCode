package JuneToAugust;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        Algorithm algorithm=new Algorithm();
        ans=algorithm.FindContinuousSequence(3);
        System.out.println(ans);
    }
}
