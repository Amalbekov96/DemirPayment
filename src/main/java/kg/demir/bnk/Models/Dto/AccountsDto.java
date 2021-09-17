package kg.demir.bnk.Models.Dto;

import kg.demir.bnk.Models.Enums.Currencies;
import kg.demir.bnk.Models.Users;
import lombok.Data;

@Data
public class AccountsDto extends BaseDto{
    private String accountNum;
    private double amount;
    private Currencies currency;
    private Users user;
}
