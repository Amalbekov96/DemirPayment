package kg.demir.bnk.Controllers;

import kg.demir.bnk.Configuration.AppConfig;
import kg.demir.bnk.Models.Dto.UsersDto;
import kg.demir.bnk.Models.Users;
import kg.demir.bnk.Service.Impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController extends BaseController<Users, UsersDto, UsersServiceImpl>{
    protected UsersController(UsersServiceImpl service) {
        super(service);
    }

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private UsersServiceImpl usersService;

    @Override
    ResponseEntity<?> create(UsersDto usersDto) {
        return usersService.create(usersDto);
    }


//    @GetMapping("/login")
//    ResponseEntity<?> Login(@RequestParam("username") String username, @RequestParam("password") String psw, HttpServletRequest request) {
//        return usersService.Login(username, psw, request);
//    }
}
