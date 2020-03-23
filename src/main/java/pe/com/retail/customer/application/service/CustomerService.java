package pe.com.retail.customer.application.service;

import java.util.List;

import pe.com.retail.customer.application.dto.CustomerDTO;
import pe.com.retail.customer.application.dto.CustomerSpecializedViewDTO;
import pe.com.retail.customer.application.dto.CustomerViewDTO;
import pe.com.retail.customer.application.dto.MessageDTO;
import pe.com.retail.customer.application.dto.StatisticCustomerDTO;

public interface CustomerService {

	public MessageDTO registerCustomer(CustomerDTO customerDTO);

	public MessageDTO updateCustomer(CustomerDTO customerDTO, String documentoIdentidad);

	public List<CustomerViewDTO> listCustomer();

	public List<CustomerViewDTO> listCustomerForName(String name);

	public MessageDTO deleteCustomer(String documentoIdentidad);

	public StatisticCustomerDTO statisticCustomers();
	
	public List<CustomerSpecializedViewDTO> listCustomerSpecialized();
}
