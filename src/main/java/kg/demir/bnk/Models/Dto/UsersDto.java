package kg.demir.bnk.Models.Dto;

import kg.demir.bnk.Models.Accounts;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Data
public class UsersDto extends BaseDto{
    private String name;
    private String password;
    private List<Accounts> account;
}
