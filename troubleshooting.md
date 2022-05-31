### 에러 모음
#### Could not initialize class org.xnio.channels.Channels + File "/WEB-INF/jsp/egovframework/com/cmm/error/******.jsp" not found
```
* 상황

1. WAS(WildFly) 실행 시, 아래 에러 2개가 지속적으로 출력됨.

  ERROR [io.undertow.request] (default task-2) UT005071: Undertow request failed HttpServerExchange{ GET /}: 
       java.lang.NoClassDefFoundError: Could not initialize class org.xnio.channels.Channel     
  ERROR [io.undertow.request] (default task-1) UT005023: Exception handling request to /:
       javax.servlet.ServletException: JBWEB004036: File "/WEB-INF/jsp/egovframework/com/cmm/error/~~~~.jsp" not found

2. JAVA Version
  
  Zulu: 8.62.0.19
  Zulu: 11.56.19
  
  환경변수 설정 : 2개 모두 (로컬 : CMD 실행하면, Zulu 11 버전 확인 / 전자정부프레임워크 WAS(WildFly) 연결 설정은 Zulu 8 버전) 

* 해결 방법        

  결론적으로 말하자면, Zulu 버전을 새로 하나 가져와서 맞췄다. (zulu8.42.0.23-ca-jdk8.0.232-win_x64 로 다운그레이드)
  
  - 환경 변수 설정을 새로 다운 받은 버전으로 진행하고, (환경변수 편집 시, 맨 위에 설정한 bin 파일을 기준으로 java -version 을 설정합니다.)
  - wildfly 연결 시, wildfly 버전 및 java = zulu 8.42.0.23 버전으로 맞춘 후 진행. 
```
#### 참고페이지
##### [에러-구글질문](https://groups.google.com/a/ortussolutions.com/g/commandbox/c/TZb2mbS5Dlg)  [에러-깃허브질문](https://github.com/WebGoat/WebGoat/issues/1250)
