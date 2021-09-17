package kg.demir.bnk.Models.Mapper.Impl;

import kg.demir.bnk.Models.Dto.PaymentsHistoryDto;
import kg.demir.bnk.Models.Mapper.PaymentsHistoryMapper;
import kg.demir.bnk.Models.PaymentsHistory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentsHistoryMapperImpl implements PaymentsHistoryMapper {
    @Override
    public PaymentsHistory toEntity(PaymentsHistoryDto paymentsHistoryDto) {
        return PaymentsHistoryMapper.INSTANCE.toEntity(paymentsHistoryDto);
    }

    @Override
    public PaymentsHistoryDto toDto(PaymentsHistory paymentsHistory) {
        return PaymentsHistoryMapper.INSTANCE.toDto(paymentsHistory);
    }

    @Override
    public List<PaymentsHistory> toListEntity(List<PaymentsHistoryDto> d) {
        return PaymentsHistoryMapper.INSTANCE.toListEntity(d);
    }

    @Override
    public List<PaymentsHistoryDto> toListDto(List<PaymentsHistory> e) {
        return PaymentsHistoryMapper.INSTANCE.toListDto(e);
    }
}
