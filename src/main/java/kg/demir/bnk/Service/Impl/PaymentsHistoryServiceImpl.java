package kg.demir.bnk.Service.Impl;

import kg.demir.bnk.Exceptions.EntityNotFound;
import kg.demir.bnk.Models.Accounts;
import kg.demir.bnk.Models.Dto.AccountsDto;
import kg.demir.bnk.Models.Dto.PaymentsHistoryDto;
import kg.demir.bnk.Models.Mapper.AccountsMapper;
import kg.demir.bnk.Models.Mapper.PaymentsHistoryMapper;
import kg.demir.bnk.Models.PaymentsHistory;
import kg.demir.bnk.Repository.AccountsRepo;
import kg.demir.bnk.Repository.PaymentsHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Service
public class PaymentsHistoryServiceImpl extends BaseServiceImpl<PaymentsHistory, PaymentsHistoryDto, PaymentsHistoryMapper, PaymentsHistoryRepo> {
    public PaymentsHistoryServiceImpl(PaymentsHistoryRepo repo, PaymentsHistoryMapper mapper) {
        super(repo, mapper);
    }

    @Autowired
    private AccountsRepo accountsRepo;
    @Autowired
    private AccountsMapper accountsMapper;
    @Autowired
    private PaymentsHistoryRepo paymentsHistoryRepo;
    @Autowired
    private PaymentsHistoryMapper paymentsHistoryMapper;

    @Transactional(rollbackFor = {RuntimeException.class, SQLException.class, EntityNotFound.class}, isolation = Isolation.SERIALIZABLE)
    public ResponseEntity<?> pay(String account, String amount) {

        Accounts accnt = accountsRepo.findByAccountNum(account);

        if(accnt == null){
            throw new RuntimeException("Was not able to find this account");
        }
        PaymentsHistoryDto paymentsHistoryDto = new PaymentsHistoryDto();

        paymentsHistoryDto.setAccount(accountsMapper.toDto(accnt));
        paymentsHistoryDto.setAmount(new BigDecimal(amount));

        AccountsDto accountsDto = accountsMapper.toDto(accountsRepo.findById(paymentsHistoryDto.getAccount().getId()).orElseThrow(() -> new EntityNotFound("This account was not found")));
        if(accountsDto.getAmount().compareTo(paymentsHistoryDto.getAmount()) < 0){
            throw new RuntimeException("This account has not enough amount");
        }
        accountsDto.setAmount(accountsDto.getAmount().subtract(paymentsHistoryDto.getAmount()));
        Accounts accounts = accountsRepo.save(accountsMapper.toEntity(accountsDto));
        if(accounts == null){
            throw new RuntimeException("Was not able to update an account");
        }

        paymentsHistoryDto.setDate(LocalDateTime.now());

        PaymentsHistory paymentsHistory = paymentsHistoryRepo.save(paymentsHistoryMapper.toEntity(paymentsHistoryDto));

        if(paymentsHistory == null){
            throw new RuntimeException("Was not able to update an payments history");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentsHistory);
    }
}
