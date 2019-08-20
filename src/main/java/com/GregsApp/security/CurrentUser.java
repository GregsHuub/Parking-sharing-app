package com.GregsApp.security;

import java.util.Collection;

import com.GregsApp.user.User;
import org.springframework.security.core.GrantedAuthority;


public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private final User user;
    private final Boolean enabled;


    public CurrentUser(String email, String password,
                       Collection<? extends GrantedAuthority> authorities, User user, Boolean enabled) {
        super(email, password, authorities);
        this.user = user;
        this.enabled = enabled;
    }

    public com.GregsApp.user.User getUser() {
        return user;
    }
}
