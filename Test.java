package com.winitech.rmw;

import lombok.Data;
import org.assertj.core.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Test {
    @org.junit.jupiter.api.Test
    public void test(){
        List<Person> personList = new ArrayList<>();
        List<Person> personList2 = new ArrayList<>();

        personList.add(new Person("kim", "20", "대구"));
        personList.add(new Person("kim", "19", "대구"));
        personList.add(new Person("kim", "18", "대구"));
        personList.add(new Person("park", "19", "대구"));

        personList2.add(new Person("kim", "19", "대구"));

        System.out.println("personList 1 >>" + System.identityHashCode(personList.get(1)));

        System.out.println("personList2 0 >>" + System.identityHashCode(personList2.get(0)));



//        Assertions.assertThat(personList.get(1)).isEqualTo(personList2.get(0));


        System.out.println("PersonList");
        personList.stream()
                .forEach(System.out::println);

        System.out.println();

        System.out.println("PersonList2");
        personList2.stream()
                .forEach(System.out::println);

        System.out.println();


        for (int i = 0; i < personList2.size(); i++) {
            personList.remove(personList2.get(i));
        }

        System.out.println("Result");
        personList.stream()
                .forEach(System.out::println);





        List<Person> personList3 = new ArrayList<>();
        List<Person> personList4 = new ArrayList<>();

        Person person1 = new Person("kim", "20", "대구");
        Person person5 = new Person("kim", "19", "대구");
        Person person3 = new Person("kim", "18", "대구");
        Person person4 = new Person("park", "19", "대구");

        Person person2 = new Person("kim", "19", "대구");

        personList3.add(person1);
        personList3.add(person3);
        personList3.add(person4);
        personList3.add(person5);

        personList4.add(person2);

        Assertions.assertThat(personList3.get(3)).isEqualTo(personList4.get(0));


//        List<Person> truePersonList = personList.stream()
//                .filter(filter -> personList2.stream()
//                        .noneMatch(target -> filter.getAge().equals(target.getAge())
//                                && filter.getName().equals(target.getName())
//                                && filter.getSido().equals(target.getSido())))
//                .collect(Collectors.toList());

        System.out.println("PersonList3");
        personList3.stream()
                .forEach(System.out::println);

        System.out.println();

        System.out.println("PersonList4");
        personList4.stream()
                .forEach(System.out::println);

        System.out.println();


        for (int i = 0; i < personList4.size(); i++) {
            personList3.remove(personList4.get(i));
        }

        System.out.println("Result");
        personList3.stream()
                .forEach(System.out::println);

    }
}


@Data
class Person {
    private String name;
    private String age;
    private String sido;

    Person(){}

    Person(String name, String age, String sido) {
        this.name = name;
        this.age = age;
        this.sido = sido;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sido='" + sido + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSido() {
        return sido;
    }

    public void setSido(String sido) {
        this.sido = sido;
    }
}
