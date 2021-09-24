package kg.demir.bnk.Service.Impl;

import kg.demir.bnk.Configuration.AppConfig;
import kg.demir.bnk.Models.Dto.UsersDto;
import kg.demir.bnk.Models.Mapper.UsersMapper;
import kg.demir.bnk.Models.Users;
import kg.demir.bnk.Repository.UsersRepo;
import kg.demir.bnk.Security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UsersServiceImpl extends BaseServiceImpl<Users, UsersDto, UsersMapper, UsersRepo>{
    public UsersServiceImpl(UsersRepo repo, UsersMapper mapper) {
        super(repo, mapper);
    }

    private final int maxAttempts = 3;

    @Autowired
    private UsersRepo usersRepo;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private SecurityConfig securityConfig;
    @Override
    public ResponseEntity<?> create(UsersDto usersDto) {
        BCryptPasswordEncoder encoder = securityConfig.passwordEncoder();
        System.out.println(usersDto.getPassword());
        String encodedPass = encoder.encode(usersDto.getPassword());
        System.out.println(encodedPass);
        usersDto.setPassword(encodedPass);
        return super.create(usersDto);
    }

    public ResponseEntity<?> Login(String name, String password, HttpServletRequest request){


        UsersDto usersDto = usersMapper.toDto(usersRepo.findByName(name));
        if(usersDto == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with name " + name + " is does not exist.");
        } else {
            BCryptPasswordEncoder encoder = securityConfig.passwordEncoder();
            if(!isBlocked(name)) {
                if (encoder.matches(password, usersDto.getPassword())) {
                    resetAttempts(name);
                    return ResponseEntity.ok("Welcome " + usersDto.getName());
                } else {
                    failedToRegister(name);
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect password or name");
                }
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This user is Blocked");
            }
        }
    }

    public void failedToRegister(String name){
        UsersDto usersDto = UsersMapper.INSTANCE.toDto(usersRepo.findByName(name));
        if (usersDto != null && !usersDto.isBlocked()) {
            int failedCounter = usersDto.getLoginAttempts();
            if (maxAttempts < failedCounter + 1) {
                usersDto.setBlocked(true); //disabling the account
            } else {
                //let's update the counter
                usersDto.setLoginAttempts(failedCounter + 1);
            }
            usersRepo.save(usersMapper.toEntity(usersDto));
        }
    }

    public void resetAttempts(String name) {
        UsersDto usersDto = UsersMapper.INSTANCE.toDto(usersRepo.findByName(name));
        if (usersDto != null) {
            usersDto.setLoginAttempts(0);
            usersDto.setBlocked(false);
            usersDto.setRoles(usersDto.getRoles());
//            usersRepo.save(UsersMapper.INSTANCE.toEntity(usersDto));
        }
    }

    public boolean isBlocked(String name) {
        UsersDto usersDto = UsersMapper.INSTANCE.toDto(usersRepo.findByName(name));
        if (usersDto != null) {
            return usersDto.getLoginAttempts() >= maxAttempts ? true : false;
        }
        return false;
    }

}
