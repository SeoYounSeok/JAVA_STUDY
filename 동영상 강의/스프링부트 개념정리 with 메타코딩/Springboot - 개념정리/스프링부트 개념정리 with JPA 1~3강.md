### 스프링이란? (1~3강)

```
1. 스프링은 프레임워크다.
2. 스프링은 오픈소스이다.
3. 스프링은 Ioc 컨테이너를 가진다.
4. 스프링은 DI를 지원한다.
5. 스프링은 엄청나게 많은 필터를 가지고 있다.
6. 스프링은 엄청나게 많은 어노테이션을 가지고 있다. (리플렉션, 컴파일체킹)
7. 스프링은 MessageConverter 를 가지고 있다. 기본 값은 현재 Json 이다.
8. 스프링은 BufferedReader와 BufferedWriter 를 쉽게 사용할 수 있다.
9. 스프링은 계속 발전 중이다.

컴파일체킹
 - 어노테이션은 컴파일러가 무시하지 않고, 힌트를 받습니다.
 - 스프링에서는 어노테이션을 통해서 객체 생성을 합니다.
   @component @Bean @Controller 해당 어노테이션들의 해당하는 약속을 한다.

@Component
Class A {
                     <- Ioc 스캔 읽어서 힙 영역에 올린다.
}

Class B {
    @Autowired
    A a;
}

  - 분석을 리플렉션이라고 합니다. : 메서드, : 필드, : 어노테이션 등을 분석하는 기법인데, 런타임시 분석합니다.
  - 로딩된 객체를 해당 변수에 집어 넣어준다.
```
