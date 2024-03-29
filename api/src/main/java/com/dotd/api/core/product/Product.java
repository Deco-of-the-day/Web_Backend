package com.dotd.api.core.product;

import com.dotd.api.core.chat.ChatSession;
import com.dotd.api.core.room.Room;
import com.dotd.api.core.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Room에 등록 된 제품
 *
 * @author Taxol
 * @version 1.0
 */
@Entity
@Getter @Setter
public class Product {

    @Id @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    private String product_name;
    private String url;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> images = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ChatSession> chatSessions = new ArrayList<>();
}