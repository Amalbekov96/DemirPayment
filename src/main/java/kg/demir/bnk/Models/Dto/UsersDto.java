package kg.demir.bnk.Models.Dto;

import kg.demir.bnk.Models.Enums.UserRoles;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UsersDto extends BaseDto{
    private String name;
    private String password;
    private boolean isBlocked;
    private int loginAttempts;
    private UserRoles roles;

    public UsersDto() {
    }
}
