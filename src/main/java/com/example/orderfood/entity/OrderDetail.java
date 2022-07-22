package com.example.orderfood.entity;

import com.example.orderfood.entity.basic.BaseEntity;
import lombok.*;

import javax.persistence.*;

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
    private OrderDetailId orderDetailId;
    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "food_id", insertable = false, updatable = false)
    private Food food;
    private String image;
    private String description;
    private int quantity;
    private double unitPrice;
}
