package kg.demir.bnk.Models;

import kg.demir.bnk.Models.Enums.Currencies;
import lombok.Data;

import javax.persistence.*;
import java.util.Currency;

@Entity
@Data
public class Accounts extends BaseEntity {

    private String accountNum;
    private double amount;
    private Currencies currency;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
}
