package kg.demir.bnk.Models.Mapper.Impl;

import kg.demir.bnk.Models.Accounts;
import kg.demir.bnk.Models.Dto.AccountsDto;
import kg.demir.bnk.Models.Mapper.AccountsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountsMapperImpl implements AccountsMapper {
    @Override
    public Accounts toEntity(AccountsDto accountsDto) {
        return AccountsMapper.INSTANCE.toEntity(accountsDto);
    }

    @Override
    public AccountsDto toDto(Accounts accounts) {
        return AccountsMapper.INSTANCE.toDto(accounts);
    }

    @Override
    public List<Accounts> toListEntity(List<AccountsDto> d) {
        return AccountsMapper.INSTANCE.toListEntity(d);
    }

    @Override
    public List<AccountsDto> toListDto(List<Accounts> e) {
        return AccountsMapper.INSTANCE.toListDto(e);
    }
}
