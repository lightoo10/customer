package pe.com.retail.customer;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.com.retail.customer.application.dto.CustomerDTO;
import pe.com.retail.customer.application.dto.CustomerViewDTO;
import pe.com.retail.customer.application.dto.MessageDTO;
import pe.com.retail.customer.application.service.impl.CustomerServiceImpl;
import pe.com.retail.customer.domain.business.CustomerBusiness;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientApplicationTests {

	@Mock
	private CustomerBusiness CustomerBusiness;

	@InjectMocks
	private CustomerServiceImpl clientServiceImpl;

	@Test
	public void registerCustomerService() {
		when(CustomerBusiness.registerCustomer(any(CustomerDTO.class))).thenReturn(new MessageDTO("0", ""));
		MessageDTO messageDTO = clientServiceImpl.registerCustomer(new CustomerDTO());
		assertEquals("0", messageDTO.getCode());
	}

	@Test
	public void updateCustomerService() {
		when(CustomerBusiness.updateCustomer(any(CustomerDTO.class))).thenReturn(new MessageDTO("0", ""));
		MessageDTO messageDTO = clientServiceImpl.updateCustomer(new CustomerDTO(), "76625318");
		assertEquals("0", messageDTO.getCode());
	}

	@Test
	public void listCustomerService() {
		List<CustomerViewDTO> lstCustomerViewDTO = new ArrayList<CustomerViewDTO>();
		lstCustomerViewDTO.add(new CustomerViewDTO("76625318", "martin", "calvo", 28));
		when(CustomerBusiness.listCustomerForName(anyString())).thenReturn(lstCustomerViewDTO);
		assertEquals(1, clientServiceImpl.listCustomerForName("martin").size());
	}

	@Test
	public void deleteCustomerService() {
		when(CustomerBusiness.deleteCustomer(anyString())).thenReturn(new MessageDTO("0", ""));
		MessageDTO messageDTO = clientServiceImpl.deleteCustomer("76625318");
		assertEquals("0", messageDTO.getCode());
	}

}
