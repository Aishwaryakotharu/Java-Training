package project;
public interface UserLoginBusiness{
	public boolean checkUser(String name,String pass);
	public boolean checkStatus(String name);
	public boolean updateStatus(String name,int loginStatus);
	public boolean registerUser(String name,String pass);
	@SuppressWarnings("unused")
	private int generatePrimaryKey() {
		//write business logic...
		return 1;
	}
}


