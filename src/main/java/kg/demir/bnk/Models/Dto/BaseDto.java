package kg.demir.bnk.Models.Dto;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class BaseDto {
    private long id;
}
