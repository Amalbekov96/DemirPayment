package kg.demir.bnk.Service.Impl;

import kg.demir.bnk.Exceptions.EntityNotFound;
import kg.demir.bnk.Models.Accounts;
import kg.demir.bnk.Models.Dto.AccountsDto;
import kg.demir.bnk.Models.Mapper.AccountsMapper;
import kg.demir.bnk.Repository.AccountsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.SQLException;

@Service
public class AccountsServiceImpl extends BaseServiceImpl<Accounts, AccountsDto, AccountsMapper, AccountsRepo>{
    public AccountsServiceImpl(AccountsRepo repo, AccountsMapper mapper) {
        super(repo, mapper);
    }

    @Autowired
    private AccountsMapper accountsMapper;
    @Autowired
    private AccountsRepo accountsRepo;

    @Transactional(rollbackFor = {RuntimeException.class, SQLException.class, EntityNotFound.class}, isolation = Isolation.SERIALIZABLE)
    public ResponseEntity<?> cash(String account, String amount) {
        AccountsDto accountsDto = accountsMapper.toDto(accountsRepo.findByAccountNum(account));

        if(accountsDto == null){
            throw new EntityNotFound("This account was not found");
        }

        if(accountsDto.getAmount().compareTo(new BigDecimal(amount)) < 0){
            throw new RuntimeException("Not enough amount to withdraw");
        }
        accountsDto.setAmount(accountsDto.getAmount().subtract(new BigDecimal(amount)));
        return ResponseEntity.status(HttpStatus.OK).body(accountsRepo.save(accountsMapper.toEntity(accountsDto)));
    }

    public ResponseEntity<?> deposit(String account, String amount) {

        AccountsDto accountsDto = accountsMapper.toDto(accountsRepo.findByAccountNum(account));

        if(accountsDto == null){
            throw new EntityNotFound("This account was not found");
        }

        accountsDto.setAmount(accountsDto.getAmount().add(new BigDecimal(amount)));
        return ResponseEntity.status(HttpStatus.OK).body(accountsRepo.save(accountsMapper.toEntity(accountsDto)));
    }
}
