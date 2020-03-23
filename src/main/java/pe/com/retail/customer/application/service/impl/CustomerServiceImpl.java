package pe.com.retail.customer.application.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.com.retail.customer.application.dto.CustomerDTO;
import pe.com.retail.customer.application.dto.CustomerSpecializedViewDTO;
import pe.com.retail.customer.application.dto.CustomerViewDTO;
import pe.com.retail.customer.application.dto.MessageDTO;
import pe.com.retail.customer.application.dto.StatisticCustomerDTO;
import pe.com.retail.customer.application.service.CustomerService;
import pe.com.retail.customer.domain.business.CustomerBusiness;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerBusiness customerBusiness;

	public CustomerServiceImpl(CustomerBusiness customerBusiness) {
		this.customerBusiness = customerBusiness;
	}

	@Override
	public MessageDTO registerCustomer(CustomerDTO customerDTO) {
		return customerBusiness.registerCustomer(customerDTO);
	}

	@Override
	public MessageDTO updateCustomer(CustomerDTO clientDTO, String documentoIdentidad) {
		clientDTO.setDocumentoIdentidad(documentoIdentidad);
		return customerBusiness.updateCustomer(clientDTO);
	}

	@Override
	public List<CustomerViewDTO> listCustomer() {
		return customerBusiness.listCustomer();
	}

	@Override
	public List<CustomerViewDTO> listCustomerForName(String name) {
		return customerBusiness.listCustomerForName(name);
	}

	@Override
	public MessageDTO deleteCustomer(String documentoIdentidad) {
		return customerBusiness.deleteCustomer(documentoIdentidad);
	}

	@Override
	public StatisticCustomerDTO statisticCustomers() {
		return customerBusiness.calculateAverageAndStandardDeviation();
	}

	@Override
	public List<CustomerSpecializedViewDTO> listCustomerSpecialized() {
		return customerBusiness.listCustomerSpecialized();
	}

}
