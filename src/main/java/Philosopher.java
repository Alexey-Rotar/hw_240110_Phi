import java.lang.Math;

public class Philosopher extends Thread {
    private String name;
    private Fork leftFork;
    private Fork rightFork;
    //private Random random;

    public Philosopher(String name, Fork leftFork, Fork rightFork){
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        //random = new Random();
    }

    @Override
    public void run(){
        try {
            synchronized (leftFork){
                eat();
            }
            think();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void eat() throws InterruptedException{
        leftFork.setState(true);
        rightFork.setState(true);
        System.out.println(name + " ест вилками " + leftFork.getName() +  " и " + rightFork.getName());
        Thread.sleep((long) (Math.random() * 1000));
        leftFork.setState(false);
        rightFork.setState(false);
        System.out.println(name + " поел, вилки " + leftFork.getName() +  " и " + rightFork.getName() + " освободились" );
    }

    public void think() throws InterruptedException{
        System.out.println(name + " думает...");
        Thread.sleep((long) (Math.random() * 1000));
        System.out.println(name + " закончил думать");
    }
}
