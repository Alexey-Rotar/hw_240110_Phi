public class Pair {
    private Fork leftFork;
    private Fork rightFork;

    public Pair(){
        this.leftFork = null;
        this.rightFork = null;
    }

    public void setForks(Fork leftFork, Fork rightFork){
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void busy(){
        leftFork.setState(false); // левая вилка занимается
        rightFork.setState(false); // правая вилка занимается
    }

    public void free(){
        leftFork.setState(true); // левая вилка освобожается
        rightFork.setState(true); // правая вилка освобожается
    }
}