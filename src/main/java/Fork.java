public class Fork {
    private final String name;
    private volatile boolean state = true; // true = доступна

    public Fork(String name){
        this.name = name;
    }

    public void setState(boolean state){
        this.state = state;
    }

    public String getName(){
        return name;
    }
}