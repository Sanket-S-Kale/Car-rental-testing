package com.gomavs.rental.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginForm {

	@NotBlank
    @Size(min=5, max=16)
    private String username;

    @NotBlank
    @Size(min=6, max=50)
    private String password;

    /*public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/
}
