package com.dotd.api.core.chat;

import com.dotd.api.core.product.Product;
import com.dotd.api.core.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class ChatSession {

    @Id @GeneratedValue
    @Column(name = "session_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User user;

    @Enumerated(EnumType.STRING)
    private ChatType type;

    @OneToMany(mappedBy = "chatSession", cascade = CascadeType.ALL)
    @ApiModelProperty(hidden = true)
    private List<ChatMessage> chatMessages = new ArrayList<>();

}
