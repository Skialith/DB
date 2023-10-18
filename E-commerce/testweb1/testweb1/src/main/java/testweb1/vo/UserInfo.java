package testweb1.vo;

public class UserInfo {
  private int userinfoid;
  private String username;
  private String password;
  private String confirmpassword;
  private String gender;
  private String phonenum;

  public String getUsername() {
	return username;
  }
  public void setUsername(String username) {
	this.username = username;
  }
  public String getPassword() {
	return password;
  }
  public void setPassword(String password) {
	this.password = password;
  }
public String getConfirmpassword() {
	return confirmpassword;
}
public void setConfirmpassword(String confirmpassword) {
	this.confirmpassword = confirmpassword;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getPhonenum() {
	return phonenum;
}
public void setPhonenum(String phonenum) {
	this.phonenum = phonenum;
}
public int getUserinfoid() {
	return userinfoid;
}
public void setUserinfoid(int userinfoid) {
	this.userinfoid = userinfoid;
}


  
}
