package reflect;

import JuneToAugust.PriorityQueueTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Student s=new Student("zhangsan");
        Class c=Student.class;
        Class l=Student.liuxing.class;
        Class str=String.class;
        int i=1;
        Constructor[] constructor = c.getConstructors();

        for(Constructor constructor1 : constructor)
        {

            System.out.println(constructor1);
        }

        System.out.println(StrTiInt("+145623"));
        PriorityQueueTest priorityQueueTest=new PriorityQueueTest();
        for(int j=1;j<20;j++)
        {
            priorityQueueTest.Insert(j);
            Double aDouble = priorityQueueTest.GetMedian();
            System.out.println(aDouble);
        }




    }


    public static int StrTiInt(String str) {
        int sign = 1;
        int sum = 0;
        if (str == null || str.length() == 0) {
            return 0;
        }
        char a[] = str.toCharArray();
        if (a[0] == '-') {
            sign = -1;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '+' || a[i] == '-') {
                if (i != 0) {
                    return 0;
                }
                continue;
            }
            if (a[i] > 57 || a[i] < 48) {
                return 0;
            }
            sum = sum * 10 + a[i] - 48;
        }
        return sum * sign;
    }
}
