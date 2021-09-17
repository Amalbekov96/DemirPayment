package kg.demir.bnk.Models.Mapper;

import kg.demir.bnk.Models.Accounts;
import kg.demir.bnk.Models.Dto.AccountsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface AccountsMapper extends BaseMapper<Accounts, AccountsDto>{
    AccountsMapper INSTANCE = Mappers.getMapper(AccountsMapper.class);
}
