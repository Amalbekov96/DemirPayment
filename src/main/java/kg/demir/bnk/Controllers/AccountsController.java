package kg.demir.bnk.Controllers;

import kg.demir.bnk.Models.Accounts;
import kg.demir.bnk.Models.Dto.AccountsDto;
import kg.demir.bnk.Service.Impl.AccountsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountsController extends BaseController<Accounts, AccountsDto, AccountsServiceImpl>{
    protected AccountsController(AccountsServiceImpl service) {
        super(service);
    }

    @Autowired
    private AccountsServiceImpl accountsService;

    @GetMapping("/cash")
    ResponseEntity<?> cash(@RequestParam("account") String account, @RequestParam("amount") String amount){
       return accountsService.cash(account, amount);
    }

    @PostMapping("/deposit")
    ResponseEntity<?> deposit(@RequestParam("account") String account, @RequestParam("amount") String amount){
        return accountsService.deposit(account, amount);
    }
}
