package com.zp.springbootvalidator.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author ZP
 * @date 2021/4/25.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -2731598327208972274L;

    @NotBlank(message = "{required}")
    private String name;

    @Email(message = "{invalid}")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}