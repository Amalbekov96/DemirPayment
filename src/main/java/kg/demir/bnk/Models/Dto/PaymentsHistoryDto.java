package kg.demir.bnk.Models.Dto;

import kg.demir.bnk.Models.Accounts;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentsHistoryDto extends BaseDto{
    private AccountsDto account;
    private BigDecimal amount;
    private LocalDateTime date;
}
