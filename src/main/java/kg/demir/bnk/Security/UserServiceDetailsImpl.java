package kg.demir.bnk.Security;

import kg.demir.bnk.Models.Users;
import kg.demir.bnk.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDetailsImpl implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        final Users users = usersRepo.findByName(name);

        System.out.println(bCryptPasswordEncoder.encode(users.getPassword()));

        if(users == null) {
            throw new UsernameNotFoundException("This user name is not found");
        }
        System.out.println(users.getRoles() + "  authoritiessssss");

        UserDetails user = User.withUsername(name).password(users.getPassword()).disabled(users.isBlocked()).authorities(users.getRoles().getGrantedAuthorities()).build();
        return user;
    }
}
