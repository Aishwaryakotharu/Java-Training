package project;

public class UserLoginBusinessImpl implements UserLoginBusiness{
	UserDAO userDAO;
	private static UserLoginBusinessImpl instance;
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	UserDTO user;
	
	public UserLoginBusinessImpl() {
		
	}
	
	@Override
	public boolean checkUser(String name, String password) {
		user=userDAO.findByName(name);
		return (user)!=null&& (user.getpass().compareTo(password) != 0)?true:false;
	}
	@Override
	public boolean checkStatus(String name) {
		return userDAO.findByName(name).getLoginStatus();
		//return (user)!=null?(user.loginStatus() == 1 ? true : false):false;
	}
	@Override
	public boolean updateStatus(String name, int loginStatus) {
		user=userDAO.findByName(name);
		user.setLoginStatus(user.getLoginStatus());
		return userDAO.updateUser(user);
	}
	@Override
	public boolean registerUser(String uname, String upass) {
		user=userDAO.findByName(uname);
		user.setname(uname);
		user.setpass(upass);
		return userDAO.insertUser(user);
	}
	public static UserLoginBusinessImpl getInstance() {
		if (instance == null) {
			synchronized (UserLoginBusinessImpl.class) {
				if (instance == null) {
					instance = new UserLoginBusinessImpl();
					instance.setUserDAO(UserDAOImpl.getInstance());
				}
			}
		}
		return instance;
	}
	
}