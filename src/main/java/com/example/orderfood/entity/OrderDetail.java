package com.example.orderfood.entity;

import com.example.orderfood.entity.basic.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "order_details")
public class OrderDetail  {
    @EmbeddedId
    private OrderDetailId orderDetailId = new OrderDetailId();

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    @JsonBackReference
    private Order order;

    @ManyToOne
    @MapsId("foodId")
    @JoinColumn(name = "food_id", insertable = false, updatable = false)
    @JsonManagedReference
    private Food food;
    private Integer quantity;
    private BigDecimal unitPrice;
}
