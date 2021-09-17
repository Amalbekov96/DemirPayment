package kg.demir.bnk.Controllers;

import kg.demir.bnk.Models.Dto.UsersDto;
import kg.demir.bnk.Models.Users;
import kg.demir.bnk.Service.Impl.UsersServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController extends BaseController<Users, UsersDto, UsersServiceImpl>{
    protected UsersController(UsersServiceImpl service) {
        super(service);
    }
}
