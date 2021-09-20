package kg.demir.bnk.Repository;

import kg.demir.bnk.Models.Accounts;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepo extends BaseRepo<Accounts>{
    Accounts findByAccountNum(String num);
}
