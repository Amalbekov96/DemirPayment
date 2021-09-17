package kg.demir.bnk.Controllers;

import kg.demir.bnk.Models.Accounts;
import kg.demir.bnk.Models.Dto.AccountsDto;
import kg.demir.bnk.Service.Impl.AccountsServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountsController extends BaseController<Accounts, AccountsDto, AccountsServiceImpl>{
    protected AccountsController(AccountsServiceImpl service) {
        super(service);
    }
}
