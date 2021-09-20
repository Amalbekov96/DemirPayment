package kg.demir.bnk.Models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class PaymentsHistory extends BaseEntity{
    @ManyToOne
    private Accounts account;
    private BigDecimal amount;
    private LocalDateTime date;
}
