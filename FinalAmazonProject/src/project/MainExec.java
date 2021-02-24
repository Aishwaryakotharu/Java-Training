package project;

import java.sql.Connection;

import java.util.Scanner;

import utility.ConnectionUtility;

public class MainExec {
	public static void main(String[] args) throws Exception {
		ifExists();
	}
	
	
	public static void ifExists() throws Exception {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter you username : ");
		String uName = scan.nextLine();
		System.out.println("Enter you password : ");
		String uPass = scan.nextLine();
		
		
		UserMethods user ;
		Connection con ;
		user = new UserMethods(uName, uPass);
		con= ConnectionUtility.createConnection();
		user.setConn(con);
		con.setAutoCommit(false);
		
		if(user.ifExist()) 
		{
			if(user.isLoggedIn()) 
				{
				System.out.println("Already logged in");
				System.out.println("do you want logout,'Y' for yes and 'N' for no");
				if (scan.nextLine().equalsIgnoreCase("Y")) 
					{
					if (user.logout() == 1)
						{
						con.commit();
						System.out.println("successfully logged out");
						user.updateStatus(0);
						}
					}
				}
				else 
				{
					System.out.println("Welcome");
					user.updateStatus(1);
					System.out.println("do you want logout,'Y' for yes and 'N' for no");
					if (scan.nextLine().equalsIgnoreCase("Y")) 
					{
						if (user.logout() == 1) 
						{
						con.commit();
						System.out.println("Thank you! successfully logged out");
						user.updateStatus(0);
						}	
						else 
						{
							System.err.println("try again error");
							return;
						}
					}
			
				}
		}
		else 
		{
			System.out.println("invalid credentials");
			System.out.println("do u want to register ");
			if (scan.nextLine().equalsIgnoreCase("Y")) 
			{
				if (user.createUser() == 1) 
				{
					con.commit();
					System.out.println("you are registered and logged in");
					System.out.println("Do U want to logout");
					System.out.println("'Y' for yes and 'N' for no");
					if (scan.nextLine().equalsIgnoreCase("Y")) 
					{
						user.logout();
						con.commit();
						System.out.println("Thank you !successfully logged out");
					}
				}
				else 
				{
					System.err.println("try again error");
					return;
				}
			}
		}
		user.closeAll();
}
}