package kg.demir.bnk.Models.Mapper;

import kg.demir.bnk.Models.Dto.UsersDto;
import kg.demir.bnk.Models.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UsersMapper extends BaseMapper<Users, UsersDto>{
    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);
}
