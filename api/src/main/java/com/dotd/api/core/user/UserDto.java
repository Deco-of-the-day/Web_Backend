package com.dotd.api.core.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto {
    private String email;
    private String nickname;
    private String password;
}
