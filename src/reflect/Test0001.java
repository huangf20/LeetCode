package reflect;

public class Test0001 {
    static class Father{
        private static final String TAG = "Father";
        final public void funA(){
            System.out.println(TAG+"   funA()");
            funB();
        }
        protected void funB(){
            System.out.println(TAG+"   funB()");
        }
    }
    static class Son extends Father{
        private static final String TAG = "Son";
        @Override
        protected void funB() {
            System.out.println(TAG+"   funB()");
        }
    }
    public static void main(String[] args) {
        Father a=new Son();
        a.funA();
    }
}
