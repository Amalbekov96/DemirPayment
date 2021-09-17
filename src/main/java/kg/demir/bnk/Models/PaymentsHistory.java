package kg.demir.bnk.Models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class PaymentsHistory extends BaseEntity{
    @ManyToOne
    private Accounts account;
    private double amount;
    private LocalDateTime date;
}
