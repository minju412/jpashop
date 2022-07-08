package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue // 자동으로 생성된다.
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // 한 명의 회원이 여러 개의 상품을 주문한다. // Order 테이블에 있는 member가 연관관계 주인이고, 나느 거울이다. (여기에 값을 넣어도 FK가 변경되지 않는다.)
    private List<Order> orders = new ArrayList<>();

}
