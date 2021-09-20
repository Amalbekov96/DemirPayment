package kg.demir.bnk.Security;

import kg.demir.bnk.Models.Users;
import kg.demir.bnk.Repository.UsersRepo;
import kg.demir.bnk.Security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDetailsImpl implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private SecurityConfig securityConfig;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        final Users users = usersRepo.findByName(name);

        if(users == null) {
            throw new UsernameNotFoundException("This user name is not found");
        }

        UserDetails user = User.withUsername(name).password(users.getPassword()).disabled(users.isBlocked()).authorities("USER").build();
        return user;
    }
}
