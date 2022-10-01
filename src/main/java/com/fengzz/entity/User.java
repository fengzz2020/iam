package com.fengzz.entity;

/**
 * user
 *
 * @author Fengzz
 * @date 2022/10/1 22:00
 * <p>
 * ******* Think twice, code once. *******
 */

public class User {

    private String username;

    private String password;

    private Long tokenCreatedAt;

    public Long getTokenCreatedAt() {
        return tokenCreatedAt;
    }

    public void setTokenCreatedAt(Long tokenCreatedAt) {
        this.tokenCreatedAt = tokenCreatedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
