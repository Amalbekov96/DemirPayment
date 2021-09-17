package kg.demir.bnk.Models.Mapper;

import kg.demir.bnk.Models.Dto.PaymentsHistoryDto;
import kg.demir.bnk.Models.PaymentsHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface PaymentsHistoryMapper extends BaseMapper<PaymentsHistory, PaymentsHistoryDto>{
    PaymentsHistoryMapper INSTANCE = Mappers.getMapper(PaymentsHistoryMapper.class);
}
