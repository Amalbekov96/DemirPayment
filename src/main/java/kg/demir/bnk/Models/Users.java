package kg.demir.bnk.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Users extends BaseEntity {

    private String name;
    private String password;
    @OneToMany(mappedBy="cart")
    private List<Accounts> account;
}
