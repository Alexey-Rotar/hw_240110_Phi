public class ForkPair {
    private Fork leftFork;
    private Fork rightFork;

    public ForkPair(){
        this.leftFork = null;
        this.rightFork = null;
    }

    /**
     * Метод объединения вилок в пару
     * @param leftFork левая вилка
     * @param rightFork правая вилка
     */
    public void setForks(Fork leftFork, Fork rightFork){
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    /**
     * Метод "занять вилки"
     */
    public void busy(){
        leftFork.setState(false);
        rightFork.setState(false);
    }

    /**
     * Метод освобождения вилок
     */
    public void free(){
        leftFork.setState(true);
        rightFork.setState(true);
    }
}