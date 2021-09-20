package kg.demir.bnk.Models.Dto;

import kg.demir.bnk.Models.Enums.Currencies;
import kg.demir.bnk.Models.Users;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountsDto extends BaseDto{
    private String accountNum;
    private BigDecimal amount;
    private Currencies currency;
    private UsersDto user;
}
