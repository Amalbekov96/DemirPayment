package kg.demir.bnk.Service;

import kg.demir.bnk.Models.BaseEntity;
import kg.demir.bnk.Models.Dto.BaseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BaseService<D extends BaseDto>{
    D findById(Long id);
    ResponseEntity<?> create(D d);
    void deleteById(Long id);
    List<D> findAll();
}
