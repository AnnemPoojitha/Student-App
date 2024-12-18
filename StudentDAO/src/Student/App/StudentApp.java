package Student.App;

import java.util.Scanner;

import Student.DAO.StudentDAO;
import Student.DTO.Student;

public class StudentApp {
public static void main(String[] args) {
	System.out.println("---Welcome to student app---");
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter option");
	int option=sc.nextInt();
	switch(option) {
	case 1:
		System.out.println("Enter id");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the name");
		String name=sc.next();
		System.out.println("Enter email");
		String email=sc.next();
		System.out.println("Enter phone number");
		String phone=sc.next();
		System.out.println("Enter password");
		String pw=sc.next();
		System.out.println("Confirm password");
		String cpw=sc.next();
		if(pw.equals(cpw)) {
			Student s=new Student(id,name,email,phone,cpw);
			boolean res=StudentDAO.insert(s);
			if(res) {
				System.out.println("Signup success...");
			}else {
				System.out.println("Signup failed");
			}
		}
		else {
			System.out.println("Password mismatch");
		}
		break;
	case 2:
		System.out.println("Enter email");
		String mail=sc.next();
		System.out.println("Enter password");
		String pass=sc.next();
		Student s=new Student(0,null,mail,null,pass);
		Student ss=StudentDAO.login(s);
		System.out.println("Hi: "+ss.getName());
		System.out.println("Id: "+ss.getId());
		System.out.println("Phone number: "+ss.getPhone());
		System.out.println("Email :"+ss.getEmail());
		break;
	}
}
}
