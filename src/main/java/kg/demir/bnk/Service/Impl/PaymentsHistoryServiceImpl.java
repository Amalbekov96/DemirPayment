package kg.demir.bnk.Service.Impl;

import kg.demir.bnk.Models.Dto.PaymentsHistoryDto;
import kg.demir.bnk.Models.Mapper.PaymentsHistoryMapper;
import kg.demir.bnk.Models.PaymentsHistory;
import kg.demir.bnk.Repository.PaymentsHistoryRepo;
import org.springframework.stereotype.Service;

@Service
public class PaymentsHistoryServiceImpl extends BaseServiceImpl<PaymentsHistory, PaymentsHistoryDto, PaymentsHistoryMapper, PaymentsHistoryRepo> {
    public PaymentsHistoryServiceImpl(PaymentsHistoryRepo repo, PaymentsHistoryMapper mapper) {
        super(repo, mapper);
    }
}
