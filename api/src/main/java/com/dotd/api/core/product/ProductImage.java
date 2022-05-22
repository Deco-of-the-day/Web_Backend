package com.dotd.api.core.product;

import com.dotd.api.core.room.Room;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class ProductImage {
    @Id @GeneratedValue
    @Column(name = "image_id")
    private Long id;

    private String image_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
