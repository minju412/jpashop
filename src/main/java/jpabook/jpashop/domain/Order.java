package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne // 여러 주문이 한 명의 회원에 속한다.
    @JoinColumn(name = "member_id") // FK의 이름이 member_id가 된다.
    private Member member; // 외래키가 있는 곳을 연관관계의 주인으로 정한다.

    @OneToMany(mappedBy = "order") // 연관관계 거울
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery; // 연관관계 주인

    private LocalDateTime orderDate; // 주문 시간

    @Enumerated(EnumType.STRING) // 반드시 STRING으로 사용해야 한다.
    private OrderStatus status; // 주문 상태 [ORDER, CANCEL]

}
