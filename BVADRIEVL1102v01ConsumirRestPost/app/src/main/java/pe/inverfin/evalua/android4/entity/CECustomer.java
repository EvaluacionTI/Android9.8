package pe.inverfin.evalua.android4.entity;

import java.io.Serializable;
import java.util.Date;

public class CECustomer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private Date dateOfBirth;

	public CECustomer() {}
	
	public CECustomer(long id, String firstName, String lastName, String email, String mobile, Date psDateOfBirth) {
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setMobile(mobile);
		this.setDateOfBirth(psDateOfBirth);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CECustomer [id=");
		builder.append(getId());
		builder.append(", firstName=");
		builder.append(getFirstName());
		builder.append(", lastName=");
		builder.append(getLastName());
		builder.append(", email=");
		builder.append(getEmail());
		builder.append(", mobile=");
		builder.append(getMobile());
		builder.append(", dateOfBirth=");
		builder.append(getDateOfBirth());
		builder.append("]");
		return builder.toString();
	}

}
