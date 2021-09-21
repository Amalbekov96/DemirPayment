package kg.demir.bnk.Controllers;

import kg.demir.bnk.Service.Impl.AccountsServiceImpl;
import kg.demir.bnk.Service.Impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/v1/endpoints")
public class WebController {

    @Autowired
    private UsersServiceImpl usersService;
    @Autowired
    private AccountsServiceImpl accountsService;

    @GetMapping("/login")
    ResponseEntity<?> login(@RequestParam("username") String account, @RequestParam("password") String amount, HttpServletRequest request){
        return usersService.Login(account, amount, request);
    }

    @PostMapping("/logout")
    ResponseEntity<?> logout(){
        return null;
    }

    @GetMapping("/payment")
    ResponseEntity<?> cash(@RequestParam("account") String account, @RequestParam("amount") String amount){
        return accountsService.cash(account, amount);
    }
}
