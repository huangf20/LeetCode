package JuneToAugust;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Test01 {
     static class Position{
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



    public static void main(String args[]) {

        for (int i = 0; i < 128; i++) {
            System.out.println((char)i+"  "+i+"  ");
        }

        Map<Integer,Integer> map=new HashMap<>();

        char[][]a=new char[3][3];
        for (char[] ar : a) {
            for (char arr :ar) {
                System.out.println(arr);
            }
        }
    }
}
