### 스프링 동작 및 기타.

```
* http 는 무엇인가?

Socket : 운영체제가 가지고 있는 것! 연결을 끊지 않음.
소켓통신 : time slice (시간을 쪼개어, 동시에 동작하는 것처럼 보인다.)
- 부하가 커질 수 있다. (끊임없이 통신하기 때문에)

http 통신  - stateless 방식
문서를 전달하는 통신

연결을 하고, 바로 끊어버리기 때문에 동일한 사람이 요청을 했어도, 다른 사람으로 인식한다.

http : html(확장자) 문서를 전달해주는 목적 / 소켓을 이용해서 만들어졌다.(시스템 콜)

* 톰켓은 무엇이고 웹 서버는 무엇인가?

내가 컴퓨터를 하나 샀고, 3개의 동영상을 가지고 있어요.
이 친구들은 내 동영상을 보고 싶은 거에요. (내 동영상(데이터)가 필요한 상황이야.)

나 (웹 서버) : 갑
친구들 (사용자) : 을

을은 갑에게 IP 주소 = url = request 를 보낸다.
갑은 을에 IP주소를 모르고, 요청에 대한 IP정보를 토대로, response 합니다.

URL : 자원 접근 스프링은 X (http://www.naver.com/a.png)
URI : 식별자 접근 (http://www.naver.com/picture/a)
    특정한 파일 요청을 할 수 없다.
    요청시에는 무조건 자바를 거친다.

서블릿 컨테이너
클라이언트가 request (자바) -> 서블릿 생성 해아함. (서블릿 컨테이너 (톰캣))

[스레드 생성] -> 서블릿 객체

* web.xml
- ServletContext 의 초기 파라미터
- Session의 유효시간 설정
- Servlet/JSP 에 대한 정의
- Servlet/JSP 매핑
- Mime Type 매핑
- Error Pages 매핑
- 리스너 / 필터 설정
- 보안

* FrontController 패턴
- 최초 앞단에서 request 요청을 받아서 필요한 클래스에 넘겨준다. 왜?
- web.xml 에서 모두 정의하기가 힘듭니다.

- 이 때 새로운 요청이 생기기 때문에 request 와 response 가 새롭게 new 될 수 있다. 그래서 아래의
  RequestDispatcher가 필요하다.

* RequestDispatcher
- 필요한 클래스 요청이 도달했을 대 FrontController에 도착한 request 와 response 를 그대로 유지시켜준다.

* DispatchServlet
- FrontController 패턴을 직접 짜거나, RequestDispatcher를 직접 구현할 필요가 없다.
- 왜냐하면 스프링에는 DispatchServlet 있기 때문이다.
- DispatchServlet = FrontContorller 패턴 + RequestDispatcher 이다.
- DispatchServlet 이 자동 생성되어 질 때 수 많은 객체가 생성(Ioc)된다.
- 해당 필터들은 내가 직접 등록할 수 있고, 기본적으로 필요한 필터들은 자동 등록 되어진다.

- DispatchServlet 에 의해 생성되어지는 수 많은 객체들은 어디에서 관리될까?

서블릿이 생성되면, 스레드가 독립적으로 생성되기 때문에 충돌이 나지 않는다.

- 공유해서 되는 것들은 ?? (모두 new 쓸필요 없자나, DB 같은 것들)
Context Loader Listener => root_ApplicationContext 파일 (공통)
```

###### 스프링 컨테이너

```
* 스프링 컨테이너
- DispatchServlet 에 의해 생성되어지는 수 많은 객체들은 어디에서 관리될까?

첫째 ApplicationContext

수 많은 객체들이 ApplicationContext에 등록된다. 이것을 IoC 라고 한다.
개발자가 직접 new 를 통해 객체를 생성하게 되면, 해당 객체를 가르키는 래퍼런스 변수를
관리하기 어렵다. 그래서 스프링이 직접 해당 객체를 관리한다.
이 때 우리는 주소를 몰라도 된다. 왜냐하마녀 필요할 때 DI하면 되기 때문이다.
DI 는 의존성 주입이라고 한다.
필요한 곳에서 ApplicationContext 에 접근하여 필요한 객체를 가져올 수 있다.
ApplicationContext는 싱글톤으로 관리되기 때문에 어디에서 접근하든 동일한 객체라는 것을 보장해준다.

ApplicationContext의 종류에는 두 가지가 있는데
(root-applicationContext와 servlet-applicationContext) 이다.

servelet-applicationContext 는 ViewResolver, Interceptor, MultipartResulver
객체를 생성하고 웹과 관련된 어노테이션 Controller, RestController 를 스캔한다.
======> 해당 파일은 DispatcherServlet 에 의해 실행된다.

root-applicationContext 는 해당 어노테이션을 제외한 어노테이션 Service, Repository 등을
스캔하고 DB관련 객체를 생성한다.(스캔이란 : 메모리에 로딩한다는 뜻)
======> 해당 파일은 ContextLoaderListener에 의해 실행된다.
ContextLoaderListener 를 실행해주는 녀석은 web.xml 이기 때문에
root-applicationContext 는 servlet-applicationContext보다 먼저 로드 된다.
당연히 servlet-applicationContext에서는 root-applicationContext가 로드한 객체를 참조할
수 있지만 그 반대는 실행 시점 때문에 불가능하다.

둘재 Bean Factory

필요한 객체를 Bean Factory 에 등록할 수 있다.
여기에 등록하면 초기에 메모리에 로드되지 않고 필요할 때 getBean()이라는 메소드를 통하여 호출하여
메모리에 로드할 수 있다. 이것 또한 IoC 이다.
그리고 필요할 때 DI하여 사용할 수 있다.
ApplicationContext와 다른 점은 Bean Factory 에 로드되는 객체들은 미리 로드 되지 않고,
필요할 때 호출되어 로드하기 때문에 lazy-loading 된다는 점이다.
```
