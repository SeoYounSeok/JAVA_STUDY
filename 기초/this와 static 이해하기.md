### this 의 역할

```
1. 자신의 주소를 가리킬 때

2. 생성자에서 다른 생성자를 호출할 때
    ex) super == this 역할

3. 자기 자신을 호출할 때
```

### Contstructor

```
기보적으로, 객체는 default Contstructor 를 자동으로 생성해준다.

예)

public class Person {
    private String name;
    private String address;

    ~~~
    getter, setter 생성
    ~~~
}

기본 Contstructor 인, public Person (){}; 이 생략되어 있다.

* Tip Contstructor 오버로딩
    매게변수를 받는 여러개의 Contstructor 를 생성하서 할 수 있다.

예)
    pulibc Person() {
        // name = "aa"; // 이런식으로 작성하면 오류가 난다. 생성자가 불리는 과정에서 객체가 초기화가 되어야지 선언이 가능하다.
        this('이름 없음'. '주소 없음')
    }
    public Person (String name, String address) {
        this.name = name;
        this.address = address;
    }

* This 사용 시 주의할 점

- 생성자의 역할은 인스턴스의 생성
- 인스턴스 생성이 완료되지 않은 시점에서 다른 코드가 있다면 오류 발생 한다.

그럼 자기 자신 호출은 어떻게 하나요?

public Person returnSelf() {
    return this;
}

Person p2 = new Person();

System.out.println(p2); // thisex.Person@~~~~ // 참조 주소값을 부름
System.out.println(p2.returnSelf()); // thisex.Person@~~~~ // this = // 참조 주소값을 부름

```

### Static 변수와 메소드

```
1. class attribute, class method 로 불림
2. 다른 언어에도 비슷한 개념으로 사용하고 있는 변수
3. static 변수를 사용하여 모든 인스턴스가 동일한 값 참조 가능
4. static variable 과 static method는 객체를 생성하지 않고 사용 가능

예) 카트회사 - 카드 생성 시 => 카드번호를 생성

* Static의 특징
1. 인스턴스가 공유(공통) 하며 사용하는 것이다.
2. new 할 때 생기는 변수가 아니다.
3. 인스턴스와 상관없이 먼저 생성된다.

Static 메소드와 변수는 Class 와 상관이 있지, 인스턴스랑은 상관 없습니다.

! 무분별하게 사용하는 것을 막기 위해서는 어떻게 해야합니까?
- private 쓰면 됩니다.

private 를 사용하게 되면 직접 호출을 못하기 때문에, getter 함수로 생성해줘야합니다.(public)

static 함수 안에는 인스턴스 변수를 사용할 수 없다.

예)
private static int serialNum = 100;
int cardNumber;

public static int getSerialNum() {
    cardNumber += 10; << 이 부분에서 에러가 납니다.
    return serialNum;
}

! 왜요?
- 생각해보자 인스턴스 변수는 인스턴스가 생성될 때 생성된다. 근데, static 은 인스턴스 생성과 상관 없다.
- 인스턴스가 생성되기전에 호출을 하는게 말이 되지 않으니까..ㅎㅎㅎㅎ 에러가 납니다.

! Tip  변수의 종류


예)
pulibc static int getSeriaNum () {
    cardNumber += 10; // 멤버변수
    int i = 0; // 지역변수
    return serialNum; // static 변수
}

세 종류의 변수는 모두 메모리, 생성시기, 생존주기가 다르다.
```

![image](https://user-images.githubusercontent.com/43161245/183276097-36249dbc-1327-4255-ae0e-d67ebe60c9a9.png)
