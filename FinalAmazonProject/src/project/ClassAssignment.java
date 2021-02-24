//package project;
//import java.io.Serializable;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//public class ClassAssignment {
//	
//	public static void main(String[] args) {
//		
//		MyApplication myapp=new MyApplication();
//		UserDAO userDAO=new UserDAOImpl();
//		UserLoginBusiness ulb=new UserLoginBusinessImpl(userDAO);
//		Object obj=Proxy.newProxyInstance(myapp.getClass().getClassLoader(),
//					new Class[] {UserLoginBusiness.class},
//						new MyInvocationHandler(new Object[] {myapp,ulb}));
//		UserLoginBusiness businessObj=(UserLoginBusiness)obj;
//		String uname="";
//		String upass="";
//		if(businessObj.checkUser(uname, upass)) {
//			if(businessObj.checkStatus(uname)) {
//				businessObj.updateStatus(uname, 1);
//				System.out.println("Weclome....");
//			}
//			else {
//				System.out.println("You are already loged in...");
//			}
//		}
//		else {
//			System.out.println("do you want to register...");
//			//if yes
//			businessObj.registerUser(uname, upass);
//		}
//	}
//}
//class MyInvocationHandler implements InvocationHandler{
//	Object o[];
//	public MyInvocationHandler(Object o[]) {
//		this.o=o;
//	}
//	@Override
//	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
//class MyApplication{
//	
//}
