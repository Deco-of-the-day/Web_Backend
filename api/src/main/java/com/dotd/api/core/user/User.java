package com.dotd.api.core.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private int userId;

	private String name;
	private String password;

}
