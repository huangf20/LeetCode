package JuneToAugust;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    PriorityQueue<Integer> low=new PriorityQueue<>();
    PriorityQueue<Integer> high=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return  o2-o1;
        }
    });
    int count =0;


    public void Insert(Integer num) {
        if(count%2==1){
            low.offer(num);
            int temp=low.poll();
            high.offer(temp);
        }
        else{
            high.offer(num);
            int temp=high.poll();
            low.offer(temp);
        }
        count++;
    }
    public Double GetMedian(){
        if(count%2==1){
            return (double)low.peek();
        }
        else{
            return (low.peek()+high.peek())/2.0;
        }
    }

}
