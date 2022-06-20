package lesson_8;

import java.util.Objects;

public class Cat {
    private static int countCat;
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat() {
        this.age = ++countCat;
        this.name = String.format("Cat_%s", countCat);
    }

    @Override
    public String toString() {
        return "Cat["  + name + ", " + age + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
