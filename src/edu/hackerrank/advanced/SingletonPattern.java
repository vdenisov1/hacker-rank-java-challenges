package edu.hackerrank.advanced;

class Singleton{
    public static final Singleton INSTANCE = new Singleton();
    public String str;

    private Singleton(){}

    public static Singleton getSingleInstance() {
        return INSTANCE;
    }

}

public class SingletonPattern {
}
