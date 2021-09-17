package kg.demir.bnk.Models.Dto;

import kg.demir.bnk.Models.Accounts;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentsHistoryDto extends BaseDto{
    private Accounts account;
    private double amount;
    private LocalDateTime date;
}
