package PracticStatement;

public class MultiThreadingPractice implements Runnable {


    @Override
    public void run() {

        System.out.println("Thread working " + Thread.currentThread());

        for (int i = 1; i < 5; i++)
        {

            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                System.out.println(e);
            }
            System.out.println(i);
        }
        System.out.println("Current State" + Thread.currentThread() + "" + Thread.currentThread().getState());
    }
}

class Driver {

    public static void main(String[] args) throws InterruptedException
    {
        MultiThreadingPractice th1 = new MultiThreadingPractice();
        MultiThreadingPractice th2 = new MultiThreadingPractice();
        MultiThreadingPractice th3 = new MultiThreadingPractice();

        Thread A = new Thread(th1);
        Thread B = new Thread(th2);
        Thread C = new Thread(th3);

        A.setName("A");
        B.setName("B");
        C.setName("C");

        A.start();
        System.out.println("Thread State : " + A.getState());
        A.join();
        System.out.println("Thread State :" + A.getState());

        B.start();
        C.start();


        System.out.println("Thread state B :" + B.getState());
        System.out.println("Thread state C :" + C.getState());
    }
}