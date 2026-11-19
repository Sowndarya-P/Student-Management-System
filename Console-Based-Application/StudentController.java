package com.sms.controller;

import java.util.List;
import java.util.Scanner;
import com.sms.model.Student;
import com.sms.service.*;

public class StudentController {
	StudentService service = new StudentService();
	Scanner ref = new Scanner(System.in);

	public void StartApp() {

		int choice;

		do {
			System.out.println("\n====STUDENT MANAGEMENT SYSTEM====");

			System.out.println("1.Add Student");
			System.out.println("2.View Student");
			System.out.println("3.Search Student");
			System.out.println("4.Exit");
			System.out.print("Enter your choice:");

			choice = ref.nextInt();

			switch (choice) {
			case 1:
				AddStudent();
				break;
			case 2:
				ViewStudent();
				break;
			case 3:
				SearchStudent();
				break;
			case 4:
				System.out.println("Thank you !!");
				break;
			default:
				System.out.println("Invalid Choice !!");
			}

		} while (choice != 4);
	}

	public void AddStudent() {
		System.out.print("Enter StudentId:");
		int Id = ref.nextInt();
		ref.nextLine();

		System.out.print("Enter StudentName:");
		String Name = ref.nextLine();

		System.out.print("Enter Department:");
		String Department = ref.nextLine();

		System.out.print("Enter Email:");
		String Email = ref.nextLine();

		System.out.print("Enter Phoneno:");
		long Number = ref.nextLong();

		Student student = new Student(Id, Name, Department, Email, Number);

		boolean result = service.addStudent(student);

		if (result) {
			System.out.println("Student Added Successfully!!");
			System.out.println();
		}
	}

	public void ViewStudent() {

		List<Student> student = service.findAll();

		if (student.isEmpty()) {
			System.out.println("No data");
		} else {
			for (Student students : student) {
				System.out.println(students);
			}
		}
		System.out.println();
	}

	public void SearchStudent() {

		System.out.print("Enter Id to Search:");
		int id = ref.nextInt();

		Student student = service.findById(id);

		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("No Id Found");
		}
		System.out.println();
	}

}