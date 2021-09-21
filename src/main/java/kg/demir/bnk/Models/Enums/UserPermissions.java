package kg.demir.bnk.Models.Enums;

public enum UserPermissions {
    USERS_READ("users:read"),
    USERS_WRITE("users:write"),
    ACCOUNT_READ("account:read"),
    ACCOUNT_WRITE("account:write"),
    PAYMENT_WRITE("payment:write"),
    PAYMENT_READ("payment:read");

    private final String permission;

    UserPermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
