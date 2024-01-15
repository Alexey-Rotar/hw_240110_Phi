public class Fork {
    private String name;
    private volatile boolean state = true; // true = доступна

    public Fork(String name){
        this.name = name;
    }

    public void setState(boolean state){
        this.state = state;
    }

    public boolean getState(){
        return state;
    }

    public String getName(){
        return name;
    }
}
