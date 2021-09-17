package kg.demir.bnk.Repository;

import kg.demir.bnk.Models.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Long> {
}
