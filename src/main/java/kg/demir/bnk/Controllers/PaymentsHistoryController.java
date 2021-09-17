package kg.demir.bnk.Controllers;

import kg.demir.bnk.Models.Dto.PaymentsHistoryDto;
import kg.demir.bnk.Models.PaymentsHistory;
import kg.demir.bnk.Service.Impl.PaymentsHistoryServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentsHistoryController extends BaseController<PaymentsHistory, PaymentsHistoryDto, PaymentsHistoryServiceImpl>{
    protected PaymentsHistoryController(PaymentsHistoryServiceImpl service) {
        super(service);
    }
}
