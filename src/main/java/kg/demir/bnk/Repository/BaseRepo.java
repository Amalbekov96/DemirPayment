package kg.demir.bnk.Repository;

import kg.demir.bnk.Models.BaseEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepo<E extends BaseEntity> extends JpaRepository<E, Long> {
}
