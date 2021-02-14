package multiThreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Test {

    public static void main(String[] args) {


        CyclicBarrier latch=new CyclicBarrier(3);



        new Thread(()->{

           // while(true) {
                System.out.println("before latch");
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("after latch");
           // }

        }).start();
        new Thread(()->{
            //while(true) {


                System.out.println("before latch");
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("after latch");
          //  }

        }).start();
        new Thread(()->{
          //  while(true){


            System.out.println("before latch");
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("after latch");
          //  }

        }).start();


    }
}
