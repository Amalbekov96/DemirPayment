package kg.demir.bnk.Service.Impl;

import kg.demir.bnk.Exceptions.EntityNotFound;
import kg.demir.bnk.Models.BaseEntity;
import kg.demir.bnk.Models.Dto.BaseDto;
import kg.demir.bnk.Models.Mapper.BaseMapper;
import kg.demir.bnk.Repository.BaseRepository;
import kg.demir.bnk.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaseServiceImpl<E extends BaseEntity, D extends BaseDto, M extends BaseMapper<E, D>, R extends BaseRepository<E>> implements BaseService<E, D> {

    @Autowired
    public BaseServiceImpl(R repo, M mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private R repo;
    private M mapper;

    @Override
    public D findById(Long id) {
        return mapper.toDto(repo.findById(id).orElseThrow(()-> new EntityNotFound("Was not found")));
    }

    @Override
    public ResponseEntity<?> create(D d) {
        return ResponseEntity.ok(mapper.toDto(repo.save(mapper.toEntity(d))));
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<D> findAll() {
        return mapper.toListDto(repo.findAll());
    }
}
