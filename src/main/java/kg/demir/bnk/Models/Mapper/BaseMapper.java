package kg.demir.bnk.Models.Mapper;

import kg.demir.bnk.Models.BaseEntity;
import kg.demir.bnk.Models.Dto.BaseDto;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BaseMapper<E extends BaseEntity, D extends BaseDto> {
    E toEntity(D d);
    D toDto(E e);
    List<E> toListEntity(List<D> d);
    List<D> toListDto(List<E> e);
}
