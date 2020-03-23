package pe.com.retail.customer.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import pe.com.retail.customer.application.dto.CustomerDTO;
import pe.com.retail.customer.application.dto.CustomerSpecializedViewDTO;
import pe.com.retail.customer.application.dto.CustomerViewDTO;
import pe.com.retail.customer.application.dto.MessageDTO;
import pe.com.retail.customer.application.dto.StatisticCustomerDTO;
import pe.com.retail.customer.application.service.CustomerService;

@Api(value = "Administrador de funciones del cliente", description = "Operaciones que realiza el cliente en el sistema")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@ApiOperation(value = "Registro de un cliente", response = MessageDTO.class)
	@PostMapping(value = "/customer/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public MessageDTO registerCustomer(
			@ApiParam(value = "Datos del cliente que se registrara", required = false) @RequestBody CustomerDTO customerDTO) {

		return customerService.registerCustomer(customerDTO);
	}

	@ApiOperation(value = "Actualizacion de un cliente", response = MessageDTO.class)
	@PutMapping(value = "/customer/{documentoIdentidad}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public MessageDTO updateCustomer(
			@ApiParam(value = "Datos del cliente que se actualizara", required = false) @RequestBody CustomerDTO customerDTO,
			@ApiParam(value = "Documento de identidad del cliente a actualizar", required = false) @PathVariable String documentoIdentidad) {

		return customerService.updateCustomer(customerDTO, documentoIdentidad);
	}

	@ApiOperation(value = "Listado de todos los cliente", response = CustomerViewDTO.class, responseContainer = "List")
	@GetMapping(value = "/customer/", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerViewDTO> listCustomer() {

		return customerService.listCustomer();
	}

	@ApiOperation(value = "Listado de clientes por nombre", response = CustomerViewDTO.class, responseContainer = "List")
	@GetMapping(value = "/customer/{name}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerViewDTO> listCustomerForName(
			@ApiParam(value = "Nombre del cliente a buscar", required = false) @PathVariable String name) {

		return customerService.listCustomerForName(name);
	}

	@ApiOperation(value = "Borrado de clientes por DNI", response = MessageDTO.class)
	@DeleteMapping(value = "/customer/{documentoIdentidad}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public MessageDTO deleteCustomer(
			@ApiParam(value = "Documento de identidad del cliente a eliminar", required = true) @PathVariable String documentoIdentidad) {

		return customerService.deleteCustomer(documentoIdentidad);
	}

	@ApiOperation(value = "Estadisticas de los cliente", response = StatisticCustomerDTO.class)
	@GetMapping(value = "/customer/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
	public StatisticCustomerDTO statisticCustomers() {

		return customerService.statisticCustomers();
	}

	@ApiOperation(value = "Listado especializado de todos los cliente", response = CustomerSpecializedViewDTO.class, responseContainer = "List")
	@GetMapping(value = "/customer/specialized", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerSpecializedViewDTO> listCustomerSpecialized() {

		return customerService.listCustomerSpecialized();
	}
}
