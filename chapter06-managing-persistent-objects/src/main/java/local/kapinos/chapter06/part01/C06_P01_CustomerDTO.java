package local.kapinos.chapter06.part01;

public class C06_P01_CustomerDTO {

	private String firstName;
	private String email;
	private String description;

	public C06_P01_CustomerDTO(String firstName, String email, String description) {
		this.firstName = firstName;
		this.email = email;
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("C07_P01_CustomerDTO [firstName=");
		builder.append(firstName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}

}