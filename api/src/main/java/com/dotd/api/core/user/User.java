package com.dotd.api.core.user;

import com.dotd.api.core.chat.ChatSession;
import com.dotd.api.core.product.Product;
import com.dotd.api.core.room.Reply;
import com.dotd.api.core.room.Room;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 22.05.04
 * 사용자 계정을 담는 엔티티
 *
 * @author Taxol
 * @version 1.0
 */
@Entity
@Getter @Setter
public class User {

	@Id @GeneratedValue
	@Column(name = "user_id")
	private Long id;

	private String name;
	private String password;

	@OneToMany(mappedBy = "user")
	private List<Room> rooms = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<Product> products = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<Reply> replies = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<ChatSession> chatSessions = new ArrayList<>();
}
