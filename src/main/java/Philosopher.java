import java.lang.Math;

public class Philosopher extends Thread {
    private final ForkPair forkPair;
    private final Fork leftFork;
    private final Fork rightFork;
    private int eatCount;
    private boolean canEat = true; // true = может есть сейчас, false = не может
    private boolean isThinking = false; // true = думает сейчас, false = нет

    public Philosopher(String name, ForkPair forkPair, Fork leftFork, Fork rightFork, int eatCount){
        super(name);
        this.forkPair = forkPair;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.eatCount = eatCount;
    }

    @Override
    public void run(){
        while (eatCount > 0){
            try {
                if (canEat){ // если может сейчас есть
                    synchronized(forkPair){ // пытается занять общий ресурс (пара вилок)
                        forkPair.setForks(leftFork, rightFork); // берется соответсвующая пара вилок
                        eat();
                    }
                }
                else
                    think();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(this.getName() + " всё!");
    }

    /**
     * Метод "поесть"
     */
    private void eat() throws InterruptedException{
        isThinking = false; // перестаёт думать
        takeForks(); // берёт вилки
        Thread.sleep((long) (Math.random() * 2000)); // ест какое-то время
        eatCount--;
        canEat = false; // только что поел
        putForks(); // возвращает вилки
    }

    /**
     * Метод "взять вилки"
     */
    private void takeForks(){
        forkPair.busy(); // вилки занимаются
        System.out.println(this.getName() + " принялся есть вилками " + leftFork.getName() +  " и " + rightFork.getName());
    }

    /**
     * Метод "положить вилки"
     */
    private void putForks(){
        forkPair.free(); // вилки освобожаются
        System.out.println(this.getName() + " поел, вилки " + leftFork.getName() +  " и " + rightFork.getName() + " освободились" );
    }

    /**
     * Метод "подумать"
     */
    private void think() throws InterruptedException{
        if (!isThinking) // если не думает сейчас, то сообщает о том, что начинает
            System.out.println(this.getName() + " задумался...");
        isThinking = true;
        Thread.sleep((long) (Math.random() * 5000));
        isThinking = false;
        canEat = true; // подумал, теперь может и поесть (не ел только что)
    }
}