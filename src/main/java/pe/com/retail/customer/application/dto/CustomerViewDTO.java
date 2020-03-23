package pe.com.retail.customer.application.dto;

public class CustomerViewDTO {

	private String documentoIdentidad;
	private String name;
	private String surnames;
	private Integer age;

	public CustomerViewDTO(String documentoIdentidad, String name, String surnames, Integer age) {
		super();
		this.documentoIdentidad = documentoIdentidad;
		this.name = name;
		this.surnames = surnames;
		this.age = age;
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

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
