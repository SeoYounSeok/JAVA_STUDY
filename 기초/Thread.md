### Thread 란?

```
* Process
    - 실행중인 프로그램
    - OS로 부터 메모리를 할당 받아 Process 가 됨.

* THread
    - 하나의 프로세스는 하나 이상의 Thread를 가지게 되고, 실제 작업을 수행하는 단위가 Thread 이다.
```

#### 1. Thread 추가 설명

```
* 멀티 스레드
    - 여러 Thread 가 자원을 공유하며 작업을 하면서 생길 수 있는
      경쟁상황(Race Condition) 발생
    - Critical Section 에 대한 동기화 구현 필요
* Thread 만드는 방법
    - Thread 클래스에서 상속받아 Thread 를 만듦.
    - Runnable interface를 구현하여 Thread를 만듦.
      📌 자바는 다중 상속이 허용되지 않으므로, 이미 다른 클래스를 상속한 경우
        Runnable interface 를 구현하여 Thread를 만듦.
```

#### 2. 동기화

```
* 동기화(Synchronization)란?
    - 두 개의 Thread 가 같은 객체에 동시 접근 시 오류가 발생하므로 동기화 필요
    - 동기화란, 임계영역에 접근한 경우 공유자원을 Lock 하여 다른 Thread 의 접근을 제어하는 것을 의미
    - Synchronized Block
      1. synchronized(참조형 수식)
      2. 현재 객체 또는 다른 객체를 Lock으로 만듦
    - Synchronized 인스턴스 메서드
      1. 현재 속해 있는 개체에 Lock 을 걺
      2. Synchronized 함수 내에서 다른 Synchronized 함수를 호출하지 않음. (DeadLock 방지)

* wait() 와 notify()
    - 리소스가 어떤 조건에서 더 이상 유효하지 않은 경우 리소스를 기다리기 위해 Thread가 wait() 상태가 된다.
    - 깨어난 Thread들 중 한 개만 자물쇠를 채우고 재시작하게 됨.
    - Thread 가 통지를 받도록 제어할 수 없으므로 모두 깨운 후 scheduling 에 의해 CPU를 점유하게 하고
      나머지는 다시 wait() 상태가 된다.
    - notify() 보다는 notifyAll() 사용을 권장한다.
      예) 북 1, 2, 3 / 사람 1, 2, 3, 4, 5, 6 이 책을 빌린다고 가정해보자
        북 1 => 사람 1
        북 2 => 사람 2
        북 3 => 사람 3
        -- wait()

        이 상황에서 만약 notify 의 경우에는 대기중인 쓰레드 중 랜덤으로 데려온다
        하지만 notifyAll 의 경우는 4, 5, 6 을 순차적으로 부른다.
```
