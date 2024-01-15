import java.lang.Math;

public class Philosopher extends Thread {
    private Pair pair;
    private Fork leftFork;
    private Fork rightFork;
    private int eatCount;
    private boolean canEat = true; // true = может есть сейчас, false = не может
    private boolean isThinking = false; // true = думает сейчас, false = нет

    public Philosopher(String name, Pair pair, Fork leftFork, Fork rightFork, int eatCount){
        super(name);
        this.pair = pair;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.eatCount = eatCount;
    }

    @Override
    public void run(){
        while (eatCount > 0){
            try {
                if (canEat){ // если может сейчас есть
                    synchronized(pair){ // занимается общий ресурс = пара вилок
                        pair.setForks(leftFork, rightFork); // берется одновременно пара вилок
                        eat();
                    }
                }
                else
                    think();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(this.getName() + " надумался и наелся!");
    }

    private void eat() throws InterruptedException{
        isThinking = false; // перестаёт думать
        takeForks(); // берёт вилки
        Thread.sleep((long) (Math.random() * 2000)); // ест какое-то время
        eatCount--;
        canEat = false; // только что поел
        putForks(); // возвращает вилки
    }

    private void takeForks(){
        pair.busy(); // вилки занимаются
        System.out.println(this.getName() + " принялся есть вилками " + leftFork.getName() +  " и " + rightFork.getName());
    }

    private void putForks(){
        pair.free(); // вилки освобожаются
        System.out.println(this.getName() + " поел, вилки " + leftFork.getName() +  " и " + rightFork.getName() + " освободились" );
    }

    private void think() throws InterruptedException{
        if (!isThinking) // если не думает сейчас, то сообщает о том, что начинает
            System.out.println(this.getName() + " задумался...");
        isThinking = true;
        Thread.sleep((long) (Math.random() * 1000));
        canEat = true; // теперь может поесть = не ел только что
    }
}
