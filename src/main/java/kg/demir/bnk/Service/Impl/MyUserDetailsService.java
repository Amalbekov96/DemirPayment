package kg.demir.bnk.Service.Impl;

import kg.demir.bnk.Models.Users;
import kg.demir.bnk.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Users user = usersRepo.findByName(name);

        if(user == null){
            throw new UsernameNotFoundException(name);
        }

        UserDetails user2 = User.withUsername(user.getName())
                .password(user.getPassword())
                .disabled(true)
                .authorities("USER").build();
        return user2;
    }
}
