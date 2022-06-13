package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// @Table(name="") - 테이블 명칭이 중복될 때 어노테이션을 사용하면 됩니다.
public class Member {
    // pk 값을 알려줘야 한다.
    @Id
    private Long id;
    private String name;

    // getter and setter 단축키 ctrl + n
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
