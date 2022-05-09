package com.dotd.api.core.room;

import com.dotd.api.core.product.Product;
import com.dotd.api.core.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  22.05.08
 *  인테리어 방 정보를 담는 엔티티
 *
 * @author Taxol
 * @version 1.0
 */
@Entity
@Getter @Setter
public class Room {
    @Id @GeneratedValue
    @Column(name = "room_id")
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private RoomType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "room")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<RoomImage> images = new ArrayList<>();
}
