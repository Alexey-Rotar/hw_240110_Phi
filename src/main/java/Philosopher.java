import java.lang.Math;

public class Philosopher extends Thread {
    private String name;
    private Fork leftFork;
    private Fork rightFork;
    boolean isThinking;
    boolean isEating;
    int count = 2;

    public Philosopher(String name, Fork leftFork, Fork rightFork){
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run(){
        try {
            while (count > 0){
                if (!leftFork.getState() && !rightFork.getState())
                    eat();
                else
                    think();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void eat() throws InterruptedException{
        leftFork.setState(true);
        rightFork.setState(true);
        isEating = true;
        System.out.println(name + " ест вилками " + leftFork.getName() +  " и " + rightFork.getName());
        Thread.sleep((long) (Math.random() * 1000));
        count--;
        leftFork.setState(false);
        rightFork.setState(false);
        System.out.println(name + " поел, вилки " + leftFork.getName() +  " и " + rightFork.getName() + " освободились" );
        isEating = false;
    }

    public void think() throws InterruptedException{
        if (isEating){
            isThinking = false;
        }
        if (!isThinking && !isEating){
            System.out.println(name + " думает...");
            isThinking = true;
        }
        if (!isThinking){
            isThinking = true;
        }

        //System.out.println(name + " закончил думать");
        //System.out.println(name + " думает...");
    }
}
