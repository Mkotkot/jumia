package com.jumia.eg;

import com.jumia.eg.dataDTO.CustomerDTO;
import com.jumia.eg.services.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CustomerServiceTest {

    @MockBean
    private CustomerService customerService;


    @Before
    public void setUp() {
        List<CustomerDTO> customerDTOList = new ArrayList();

//        customerDTOList.add(new CustomerDTO("(212) 6007989253")); // bad case
        customerDTOList.add(new CustomerDTO("(212) 698054317"));
//        customerDTOList.add(new CustomerDTO("(212) 6546545369"));
//        customerDTOList.add(new CustomerDTO("(212) 6617344445"));
        customerDTOList.add(new CustomerDTO("(212) 691933626"));
//        customerDTOList.add(new CustomerDTO("(212) 633963130"));
//        customerDTOList.add(new CustomerDTO("(212) 654642448"));
//        customerDTOList.add(new CustomerDTO("(258) 847651504"));
//        customerDTOList.add(new CustomerDTO("(258) 846565883"));
//        customerDTOList.add(new CustomerDTO("(258) 849181828"));
//        customerDTOList.add(new CustomerDTO("(258) 84330678235"));
//        customerDTOList.add(new CustomerDTO("(258) 847602609"));
//        customerDTOList.add(new CustomerDTO("(258) 042423566"));
//        customerDTOList.add(new CustomerDTO("(258) 823747618"));
//        customerDTOList.add(new CustomerDTO("(258) 848826725"));
//        customerDTOList.add(new CustomerDTO("(256) 775069443"));
//        customerDTOList.add(new CustomerDTO("(256) 7503O6263"));
//        customerDTOList.add(new CustomerDTO("(256) 704244430"));
//        customerDTOList.add(new CustomerDTO("(256) 7734127498"));
//        customerDTOList.add(new CustomerDTO("(256) 7771031454"));
//        customerDTOList.add(new CustomerDTO("(256) 3142345678"));
//        customerDTOList.add(new CustomerDTO("(256) 714660221"));
//        customerDTOList.add(new CustomerDTO("(251) 9773199405"));
//        customerDTOList.add(new CustomerDTO("(251) 914701723"));
//        customerDTOList.add(new CustomerDTO("(251) 911203317"));
//        customerDTOList.add(new CustomerDTO("(251) 9119454961"));
//        customerDTOList.add(new CustomerDTO("(251) 914148181"));
//        customerDTOList.add(new CustomerDTO("(251) 966002259"));
//        customerDTOList.add(new CustomerDTO("(251) 988200000"));
//        customerDTOList.add(new CustomerDTO("(251) 924418461"));
//        customerDTOList.add(new CustomerDTO("(251) 911168450"));

        when(customerService.getCustomersList()).thenReturn(customerDTOList);
    }


    @Test
    public void TestCustomersPhones() {

        List<String> list = new ArrayList();
        list.add("\\(237\\)\\ ?[2368]\\d{7,8}$");
        list.add("\\(251\\)\\ ?[1-59]\\d{8}$");
        list.add("\\(212\\)\\ ?[5-9]\\d{8}$");
        list.add("\\(258\\)\\ ?[28]\\d{7,8}$");
        list.add("\\(256\\)\\ ?\\d{9}$");
        List<CustomerDTO> customers = customerService.getCustomersList();
        AtomicBoolean flag = new AtomicBoolean(false);
        customers.forEach(dto -> {
            flag.set(false);
            for (String reg : list) {
                if (dto.getPhone().matches(reg)) {
                    flag.set(true);
                    break;
                }
            }
            assert flag.get();
        });
    }
}
