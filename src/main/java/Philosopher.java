import java.lang.Math;

public class Philosopher extends Thread {
    private String name;
    private Fork leftFork;
    private Fork rightFork;
    private int eatCount;
    private boolean canEat = true; // true = может есть сейчас, false = не может
    private boolean isThinking = false; // true = думает сейчас, false = нет

    public Philosopher(String name, Fork leftFork, Fork rightFork, int eatCount){
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.eatCount = eatCount;
    }

    @Override
    public void run(){
        try {
            while (eatCount > 0){
                if (leftFork.getState() && rightFork.getState() && canEat)
                    eat();
                else
                    think();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void eat() throws InterruptedException{
        isThinking = false;
        takeForks();
        Thread.sleep((long) (Math.random() * 1000));
        eatCount--;
        canEat = false; // только что поел
        putForks();
    }

    private void takeForks(){
        leftFork.setState(false); // вилка занимается
        rightFork.setState(false); // вилка занимается
        System.out.println(name + " начал есть вилками " + leftFork.getName() +  " и " + rightFork.getName());
    }

    private void putForks(){
        leftFork.setState(true); // вилка освобожается
        rightFork.setState(true); // вилка освобожается
        System.out.println(name + " поел, вилки " + leftFork.getName() +  " и " + rightFork.getName() + " освободились" );
    }

    private void think() throws InterruptedException{
        if (!isThinking) // если не думает сейчас, сообщает, что начинает
            System.out.println(name + " задумался...");
        isThinking = true;
        Thread.sleep((long) (Math.random() * 7000));
        canEat = true; // не ел только что
    }
}
