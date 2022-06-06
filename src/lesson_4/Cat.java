package lesson_4;

public class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + ", " + age;
    }

    @Override
    public boolean equals(Object obj) {
        return (age == ((Cat)obj).getAge()) && (name.equals(((Cat) obj).getName()));
    }
}
