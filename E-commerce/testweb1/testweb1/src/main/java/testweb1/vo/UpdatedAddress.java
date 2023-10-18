package testweb1.vo;

public class UpdatedAddress {
	private String updatedUsername;
	private String updatedPassword;
	private String address;
	public String getUpdatedUsername() {
		return updatedUsername;
	}
	public void setUpdatedUsername(String updatedUsername) {
		this.updatedUsername = updatedUsername;
	}
	public String getUpdatedPassword() {
		return updatedPassword;
	}
	public void setUpdatedPassword(String updatedPassword) {
		this.updatedPassword = updatedPassword;
	}
	@Override
	public String toString() {
		return "UpdatedUserInfo [updatedUsername=" + updatedUsername + ", updatedPassword=" + updatedPassword + "]";
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
