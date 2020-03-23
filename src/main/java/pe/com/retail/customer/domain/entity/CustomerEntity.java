package pe.com.retail.customer.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity(name = "CUSTOMER")
@ApiModel(description = "Toda la información del Cliente")
public class CustomerEntity {

	@Id
	@Column(name = "DNI")
	@ApiModelProperty(notes = "Documento de identidad del cliente")
	private String documentoIdentidad;

	@Column(name = "NAME")
	@ApiModelProperty(notes = "Nombre del cliente")
	private String name;

	@Column(name = "LASTNAME")
	@ApiModelProperty(notes = "Apellido paterno del cliente")
	private String lastName;

	@Column(name = "SECONDLASTNAME")
	@ApiModelProperty(notes = "Apellido materno del cliente")
	private String secondLastName;

	@Column(name = "DATEBIRTH")
	@ApiModelProperty(notes = "Fecha de nacimiento del cliente")
	private String dateBirth;

	public CustomerEntity() {
	}

	public CustomerEntity(String documentoIdentidad, String name, String lastName, String secondLastName,
			String dateBirth) {
		this.documentoIdentidad = documentoIdentidad;
		this.name = name;
		this.lastName = lastName;
		this.secondLastName = secondLastName;
		this.dateBirth = dateBirth;
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
