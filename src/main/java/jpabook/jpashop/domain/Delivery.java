package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery") // 연관관계 거울
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // 반드시 STRING으로 사용해야 한다.
    private DeliveryStatus status; // READY, COMP

}
