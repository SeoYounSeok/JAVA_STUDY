package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        // jpa , 엔티티매니저팩토리를 하나씩 만들어야하고, 데이터베이스가 하나씩 묶여서 돌아간다
        // 뒤의 헬로라는 정보를 가져와서 읽는다.
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager(); // 고객 요청이 올 때마다 썼다가 버리는 것. 엔티티 매니저는 쓰레드 간에 공유 X

        // JPA 의 모든 데이터 변경은 트랜잭션 안에서 사용
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            // Member findMember = em.find(Member.class, 1L); // pk 값으로 조회
            // findMember.setName("HelloJPA"); // 수정

            // 나이가 18살 이상인 회원을 검색하고 싶으면 어떻게 해??..
            // JPQL 이라는 것을 사용한다. - 쿼리를 자세하게 보면 뭔가 이상하다 -> 객체 기준으로 가져온다..?
            // 이렇게 쓰면 무슨 장점이 있는가?
            // JPQL 엔티티 객체 중심으로 개발한다.
            // SQL 은 데이터베이스 테이블을 중심으로 개발한다.
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5) // 앞에서 몇개
                    .setMaxResults(8) // rownum 기능을 하는거야 !
                    .getResultList();
            for (Member member : result){
                System.out.println("member.name = " + member.getName());
            }
            // 커밋을 꼭해줘야 반영이 됩니다.
            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
