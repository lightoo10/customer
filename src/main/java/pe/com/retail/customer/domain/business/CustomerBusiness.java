package pe.com.retail.customer.domain.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pe.com.retail.customer.application.dto.CustomerDTO;
import pe.com.retail.customer.application.dto.CustomerSpecializedViewDTO;
import pe.com.retail.customer.application.dto.CustomerViewDTO;
import pe.com.retail.customer.application.dto.MessageDTO;
import pe.com.retail.customer.application.dto.StatisticCustomerDTO;
import pe.com.retail.customer.domain.entity.CustomerEntity;
import pe.com.retail.customer.domain.entity.ParameterEntity;
import pe.com.retail.customer.domain.repository.CustomerRepository;
import pe.com.retail.customer.domain.repository.ParameterRepository;
import pe.com.retail.customer.domain.util.Constants;
import pe.com.retail.customer.domain.util.StatisticalCalculation;

@Service
public class CustomerBusiness {

	private final CustomerRepository customerRepository;
	private final ParameterRepository parameterRepository;

	public CustomerBusiness(CustomerRepository customerRepository, ParameterRepository parameterRepository) {
		this.customerRepository = customerRepository;
		this.parameterRepository = parameterRepository;
	}

	public MessageDTO registerCustomer(CustomerDTO clientDTO) {
		try {
			customerRepository.registerCustomer(clientDTO.convertEntity());
			return new MessageDTO("1", "Registro Exitoso");
		} catch (Exception e) {
			return new MessageDTO("0", "Error al registrar.");
		}
	}

	public MessageDTO updateCustomer(CustomerDTO clientDTO) {
		try {
			customerRepository.registerCustomer(clientDTO.convertEntity());
			return new MessageDTO("1", "Registro Actualizado");
		} catch (Exception e) {
			return new MessageDTO("0", "Error al actualizar.");
		}
	}

	public List<CustomerViewDTO> listCustomer() {
		return convertLstClientView(customerRepository.findCustomers());
	}

	public List<CustomerViewDTO> listCustomerForName(String name) {
		return convertLstClientView(customerRepository.findCustomerByName(name));
	}

	public MessageDTO deleteCustomer(String documentoIdentidad) {
		try {
			customerRepository.deleteCustomer(documentoIdentidad);
			return new MessageDTO("1", "Registro Eliminado");
		} catch (Exception e) {
			return new MessageDTO("0", "Error al eliminar.");
		}
	}

	public StatisticCustomerDTO calculateAverageAndStandardDeviation() {
		StatisticCustomerDTO statisticCustomerDTO = new StatisticCustomerDTO();

		List<Integer> lstAge = listCustomer().stream().map(p -> p.getAge()).collect(Collectors.toList());

		statisticCustomerDTO.setAverage(StatisticalCalculation.average(lstAge));
		statisticCustomerDTO.setStandardDeviation(StatisticalCalculation.standardDeviation(lstAge));
		return statisticCustomerDTO;
	}

	public List<CustomerSpecializedViewDTO> listCustomerSpecialized() {
		return convertLstClientSpecializedView(customerRepository.findCustomers());
	}

	public List<CustomerViewDTO> convertLstClientView(List<CustomerEntity> customerEntity) {
		List<CustomerViewDTO> lstCustomer = new ArrayList<CustomerViewDTO>();
		customerEntity.forEach(customer -> {
			lstCustomer.add(new CustomerViewDTO(customer.getDocumentoIdentidad(), customer.getName(),
					customer.getLastName().concat(" ").concat(customer.getSecondLastName()),
					calculateAge(customer.getDateBirth())));
		});
		return lstCustomer;
	}

	public List<CustomerSpecializedViewDTO> convertLstClientSpecializedView(List<CustomerEntity> customerEntity) {
		List<CustomerSpecializedViewDTO> lstCustomer = new ArrayList<CustomerSpecializedViewDTO>();
		ParameterEntity parameterEntity = parameterRepository.findParameter(Constants.PARAMETER_TIME_LIFE);
		customerEntity.forEach(customer -> {
			lstCustomer.add(new CustomerSpecializedViewDTO(customer.getDocumentoIdentidad(), customer.getName(),
					customer.getLastName().concat(" ").concat(customer.getSecondLastName()),
					calculateAge(customer.getDateBirth()), calculateDeathDate(customer.getDateBirth(), parameterEntity.getValueParameter())));
		});
		return lstCustomer;
	}

	public Integer calculateAge(String dateBirth) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate fechaNac = LocalDate.parse(dateBirth, fmt);
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);
		return periodo.getYears();
	}

	public String calculateDeathDate(String dateBirth, String timeLife) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(dateBirth));
			c.add(Calendar.YEAR, Integer.parseInt(timeLife));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sdf.format(c.getTime());
	}

}
