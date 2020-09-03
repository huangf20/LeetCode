package JuneToAugust;

import java.util.*;

public class Test {
    int count=0;
    public static void main(String args[]) {
        Test test=new Test();
        test.hanoi(4,'a','b','c');
        System.out.println("一共移动了"+test.count+"次");
        char a='5';
        char b='6';
        System.out.println(a+b);

        /*PriorityQueue<Integer> low=new PriorityQueue<>();
        PriorityQueue<Integer> high=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        char[] chars={'a','b','c','e','s','f','c','s','a','d','e','e'};
        HasPathInMatrix hasPathInMatrix=new HasPathInMatrix();
        String s="abcescfdee";
        System.out.println(hasPathInMatrix.hasPath(chars,3,4, s.toCharArray()));


        ArrayList<Integer> test=new ArrayList<>();
        for(int i=0;i<10;i++){
            test.add(i*2);
        }
        for(int a : test){
            System.out.print(a+"  ");
        }
        Collections.reverse(test);
        for(int a : test){
            System.out.print(a+"  ");
        }*/
    }

    public  void hanoi(int n, char a, char b, char c)
    {
        if(n==1)
        {
            System.out.println(a+"-->"+c);
            count++;
            return;
        }

        hanoi(n-1,a,c,b);
        hanoi(1,a,b,c);
        hanoi(n-1,b,a,c);
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size)
    {
        ArrayList<Integer>res=new ArrayList<>();
        for (int i = 0; i < num.length-size+1; i++) {
            int[] temp = Arrays.copyOfRange(num, i, i + size);
            Arrays.sort(temp);
            res.add(temp[size-1]);
        }
        return res;
    }
}
