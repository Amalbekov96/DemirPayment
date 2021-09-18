package kg.demir.bnk.Repository;

import kg.demir.bnk.Models.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends BaseRepo<Users>{
    Users findByName(String name);
}
