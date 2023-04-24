package com.example.blogStepOne.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.Length;

import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 4, max = 128)
    private String name;

    @NotEmpty
    private String password;

    @NotEmpty
    @Email
    private String email;

    @Column(name = "is_locked")
    private int isLocked;

    public String getEmail() {
        return email;
    }

    public int getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(int isLocked) {
        this.isLocked = isLocked;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    private static final long serialVersionUID = 1L;

    public Long getId() {return id;}

    public void setId(Long id) { this.id = id;}

    public String getName(){
        return name;
    }
    public void setName(String name) { this.name = name; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
