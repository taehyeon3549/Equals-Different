# 객체 비교 to use Equals
 
## Testcode

``` java
public class EqualsTest {
    @Test
    void Test(){
        System.out.println("기본 객체 비교");
        TestVo vo = new TestVo("Tester2", 13);
        TestVo vo2 = new TestVo("Tester2", 13);
        System.out.println("vo  >>" +vo.toString());
        System.out.println("vo2 >>" +vo2.toString());
        System.out.println("기본 객체 비교 결과 >> " + vo.equals(vo2));


        System.out.println("Lombok 어노테이션 객체 비교");
        TestVo2 vo20 = new TestVo2("Tester2", 13);
        TestVo2 vo21 = new TestVo2("Tester2", 13);
        System.out.println("vo20 >>" +vo20.toString());
        System.out.println("vo21 >>" +vo21.toString());
        System.out.println("Lombok 어노테이션 객체 비교 결과 >> " + vo20.equals(vo21));
    }
}

class TestVo{
    String name = "";
    int age = 0;

    TestVo(){}

    TestVo(String name , int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestVo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }    
}

@Data
class TestVo2{
    String name = "";
    int age = 0;

    TestVo2(){}

    TestVo2(String name , int age){
        this.name = name;
        this.age = age;
    }
}                         
```


## 결과
![20220308_111122](https://user-images.githubusercontent.com/39556223/157152395-446cbacc-1dff-4fc3-82f2-34e64544961f.png)

------
<br> 


- 기본적인 equals인 경우에는 memory 주소 값을 통한 Object를 비교
- Lombok @Data는 어노테이션을 통해 생성되는 equals()와 hashcode()를 통해 객체의 instance와 멤버변수를 비교
- 연계에서 이전 값과 이후 값을 비교하는데 있어서 해당 부분을 발견
- 다시한번 Lombok을 통해 간결화 된 코드의 정의를 공부 해야되는 것을 확인

<br> 

## [해결 방법]
- 기본 VO에 equals와 hashCode()를 override 해서 원하는 결과 도출
```java
   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       TestVo testVo = (TestVo) o;
       return age == testVo.age && Objects.equals(name, testVo.name);
   }

   @Override
   public int hashCode() {
       return Objects.hash(name, age);
   }
```

- Lombok의 @Data 를 활용하여 원하는 결과 도출
```java
    @Data
    class testvo(){
        ```
    }
```

<br> 


## [활용 예제]
```java
    List<Person> personList = new ArrayList<>();
    List<Person> personList2 = new ArrayList<>();

    personList.add(new Person("kim", "20", "대구"));
    personList.add(new Person("kim", "19", "대구"));
    personList.add(new Person("kim", "18", "대구"));
    personList.add(new Person("park", "19", "대구"));

    personList2.add(new Person("kim", "19", "대구"));

    for (int i = 0; i < personList2.size(); i++) {
            personList.remove(personList2.get(i));
    }

    System.out.println("Result");
    personList.stream()
            .forEach(System.out::println);

    Assertions.assertThat(personList3.get(3)).isEqualTo(personList4.get(0));
```
## 결과

![20220308_112342](https://user-images.githubusercontent.com/39556223/157153746-08266510-506a-4a1e-9b7f-2dc5a9ede750.png)
<br>

## [참고 사이트]
- https://projectlombok.org/features/EqualsAndHashCode
- https://www.artima.com/articles/how-to-write-an-equality-method-in-java
