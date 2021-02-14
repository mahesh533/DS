package multiThreading;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccLiveLock {

    int id;
    double ammount;

    ReentrantLock lock= new ReentrantLock();

    public BankAccLiveLock(int id,double ammount){
        this.id=id;
        this.ammount=ammount; 

    }

    public boolean withDraw(double cash){
        if(this.lock.tryLock()){

            this.ammount-=cash;
            System.out.println("WithDrawn Ammount "+cash+" from Account "+id+"total Ammount"+ammount);
            return true;
        }
        return false;
    }

    public boolean deposit(double cash){
        if(this.lock.tryLock()){

            this.ammount+=cash;
            System.out.println("Deposited Ammount "+cash+" to Account "+id+"total Ammount"+ammount);
            return true;
        }
        return false;
    }

    public boolean transfer( BankAccLiveLock from,BankAccLiveLock to, double ammount){

        if(from.lock.tryLock()){
            if(from.withDraw(ammount)) {

                if (to.deposit(ammount)) {
                    return true;
                } else {
                    from.deposit(ammount);
                    System.out.println("Deposited Ammount " + ammount + " Back to Account " + from.id);
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {

        BankAccLiveLock student=new BankAccLiveLock(1,200000);
        BankAccLiveLock teacher=new BankAccLiveLock(2,200000);

        new Thread(()->{

            while(true){
                student.transfer(student,teacher,200);
            }


        }).start();

        new Thread(()->{
            while (true) {
                student.transfer(teacher, student, 200);
            }


        }).start();

    }



}
