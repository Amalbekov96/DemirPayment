package kg.demir.bnk.Service.Impl;

import kg.demir.bnk.Models.Dto.UsersDto;
import kg.demir.bnk.Models.Mapper.UsersMapper;
import kg.demir.bnk.Models.Users;
import kg.demir.bnk.Repository.UsersRepo;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl extends BaseServiceImpl<Users, UsersDto, UsersMapper, UsersRepo>{
    public UsersServiceImpl(UsersRepo repo, UsersMapper mapper) {
        super(repo, mapper);
    }
}
