package kg.demir.bnk.Models.Enums;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;
import static kg.demir.bnk.Models.Enums.UserPermissions.*;

public enum UserRoles {
    CLIENT(Sets.newHashSet(ACCOUNT_READ, ACCOUNT_WRITE)),
    ADMIN(Sets.newHashSet(USERS_READ, USERS_WRITE, ACCOUNT_WRITE, ACCOUNT_READ));

    private final Set<UserPermissions> permissions;

    UserRoles(Set<UserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermissions> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
