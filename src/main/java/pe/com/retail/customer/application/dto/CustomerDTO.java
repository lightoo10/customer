package pe.com.retail.customer.application.dto;

import pe.com.retail.customer.domain.entity.CustomerEntity;

public class CustomerDTO {

	private String documentoIdentidad;
	private String name;
	private String lastName;
	private String secondLastName;
	private String dateBirth;

	public CustomerEntity convertEntity() {
		return new CustomerEntity(documentoIdentidad, name, lastName, secondLastName, dateBirth);
	}

	public String getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	public void setDocumentoIdentidad(String documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public String getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

}
