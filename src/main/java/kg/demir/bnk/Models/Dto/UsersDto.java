package kg.demir.bnk.Models.Dto;

import lombok.Data;

@Data
public class UsersDto extends BaseDto{
    private String name;
    private String password;
    private boolean isBlocked;
    private int loginAttempts;

    public UsersDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UsersDto() {
    }
}
