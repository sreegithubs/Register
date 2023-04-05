package com.main;

import java.util.Scanner;

import com.entity.Details;
import com.entity.JDBCcon;

public class App1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		JDBCcon jc = new JDBCcon();
		System.out.println("Enter Name");
		String name0 = scanner.next();
		System.out.println("Enter Email");
		String email = scanner.next();
		System.out.println("Enter password");
		String pw = scanner.next();
		System.out.println("Enter Mobile number");
		String phone = scanner.next();
		System.out.println("enter DOB");
		String dob = scanner.next();
		System.out.println("enter Gender");
		String gender = scanner.next();

		Details details = new Details();

		details.setName(name0);
		details.setEmail(email);
		details.setPassword(pw);
		details.setNumber(phone);
		details.setDob(dob);
		details.setGender(gender);
//		JDBCcon.createTable(details);
		JDBCcon.save(details);

	}

}
