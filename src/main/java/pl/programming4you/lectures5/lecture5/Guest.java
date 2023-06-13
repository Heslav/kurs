package pl.programming4you.lectures5.lecture5;

public class Guest {
    private final String name;
    private final int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Guest(String name, int age) {
        this.name = name;
        this.age = age;
    }
}