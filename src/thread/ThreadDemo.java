package thread;

public class ThreadDemo {
    private boolean flag=true;
    public synchronized void printA(){
        while (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A");
        flag=false;
        this.notify();
    }

    public synchronized void printB(){
        while (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("B");
        flag=true;
        this.notify();
    }

    public static void main(String[] args) {
        final ThreadDemo threadDemo=new ThreadDemo();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                threadDemo.printA();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                threadDemo.printB();
            }
        }).start();
    }
}
