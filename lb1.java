import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        // Создаем массив объектов
        Person[] people = new Person[]{
                new Person("Ivan", 25, true),
                new Person("Maria", 30, false),
                new Person("John", 20, true),
                new Person("Kate", 35, false),
                new Person("Peter", 28, true),
                new Person("Alice", 24, false),
                new Person("Alex", 32, true),
                new Person("Olga", 29, false),
                new Person("Mark", 21, true),
                new Person("Anna", 27, false),
                new Person("Paul", 31, true),
                new Person("Julia", 26, false)
        };

        // Сортируем массив по полю "возраст"
        Arrays.sort(people, Comparator.comparing(Person::getAge));

        // Сохраняем отсортированный массив в файл
        try (FileWriter writer = new FileWriter("output.txt")) {
            for (Person person : people) {
                writer.write(person.toString() + "\n"); // записываем все поля объекта подряд
            }
        }
    }

    // Определяем класс Person с полями разных типов
    static class Person {
        private String name;
        private int age;
        private boolean isMale;

        public Person(String name, int age, boolean isMale) {
            this.name = name;
            this.age = age;
            this.isMale = isMale;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public boolean isMale() {
            return isMale;
        }

        // Переопределяем метод toString для вывода всех полей объекта
        @Override
        public String toString() {
            return 
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", isMale=" + isMale 
                    ;
        }
    }
}