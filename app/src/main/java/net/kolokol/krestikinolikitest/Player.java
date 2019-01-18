package net.kolokol.krestikinolikitest;

public class Player {
    private String name;

    public Player(String name){
        this.name = name;
    }
    public CharSequence getName(){
        return (CharSequence) name;
    }
}
