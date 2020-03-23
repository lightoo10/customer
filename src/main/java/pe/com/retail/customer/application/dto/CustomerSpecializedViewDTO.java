package pe.com.retail.customer.application.dto;

public class CustomerSpecializedViewDTO extends CustomerViewDTO{

	private String deathDate;

	public CustomerSpecializedViewDTO(String documentoIdentidad, String name, String surnames, Integer age, String deathDate) {
		super(documentoIdentidad, name, surnames, age);
		this.deathDate = deathDate;
	}

	public String getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}
}
