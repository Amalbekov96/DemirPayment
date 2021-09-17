package kg.demir.bnk.Service.Impl;

import kg.demir.bnk.Models.Accounts;
import kg.demir.bnk.Models.Dto.AccountsDto;
import kg.demir.bnk.Models.Mapper.AccountsMapper;
import kg.demir.bnk.Repository.AccountsRepo;
import org.springframework.stereotype.Service;

@Service
public class AccountsServiceImpl extends BaseServiceImpl<Accounts, AccountsDto, AccountsMapper, AccountsRepo>{
    public AccountsServiceImpl(AccountsRepo repo, AccountsMapper mapper) {
        super(repo, mapper);
    }
}
