package pe.com.retail.customer.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity(name = "PARAMETER")
@ApiModel(description = "Toda la información del parámetro")
public class ParameterEntity {

	@Id
	@Column(name = "ID_PARAMETER")
	@ApiModelProperty(notes = "Identificador del parámetro")
	private String idParameter;

	@Column(name = "NAME_PARAMETER")
	@ApiModelProperty(notes = "Nombre del parámetro")
	private String nameParameter;

	@Column(name = "VALUE_PARAMETER")
	@ApiModelProperty(notes = "Valor del parámetro")
	private String valueParameter;

	public ParameterEntity() {
	}

	public ParameterEntity(String idParameter, String nameParameter, String valueParameter) {
		this.idParameter = idParameter;
		this.nameParameter = nameParameter;
		this.valueParameter = valueParameter;
	}

	public String getIdParameter() {
		return idParameter;
	}

	public void setIdParameter(String idParameter) {
		this.idParameter = idParameter;
	}

	public String getNameParameter() {
		return nameParameter;
	}

	public void setNameParameter(String nameParameter) {
		this.nameParameter = nameParameter;
	}

	public String getValueParameter() {
		return valueParameter;
	}

	public void setValueParameter(String valueParameter) {
		this.valueParameter = valueParameter;
	}

}
