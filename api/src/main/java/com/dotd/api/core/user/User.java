package com.dotd.api.core.user;

import com.dotd.api.core.chat.ChatSession;
import com.dotd.api.core.product.Product;
import com.dotd.api.core.room.Reply;
import com.dotd.api.core.room.Room;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 사용자 계정을 담는 엔티티
 *
 * @author Taxol
 * @version 1.0
 */
@Entity
@Getter @Setter
public class User {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	private String email;
	private String nickname;
	private String password;

	@OneToMany(mappedBy = "user")
	private List<Room> rooms = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<Product> products = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<Reply> replies = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<ChatSession> chatSessions = new ArrayList<>();

	//== 생성 메서드 ==//
	public static User createUser (String email, String nickname, String password) {
		User user = new User();
		user.setEmail(email);
		user.setNickname(nickname);
		user.setPassword(password);

		return user;
	}
}
