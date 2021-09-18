package kg.demir.bnk.Models;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Users extends BaseEntity {

    private String name;
    private String password;
    private boolean isBlocked;
    private int loginAttempts;
}
