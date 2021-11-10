package com.zahid.itc.whiteboard;

public class WhiteBoardTest {

	public static void main(String[] args) {
		
		WhiteBoard wb = new WhiteBoard();
		Teacher t1= new Teacher(wb);

		Student s1 = new Student("Alex", wb);
		Student s2 = new Student("Lee", wb);
		Student s3 = new Student("Cooper", wb);
		Student s4 = new Student("David", wb);
		Student s5 = new Student("Jane", wb);

		t1.start();
		
		s1.start();
		s2.start();
		s3.start();
		s4.start();
		s5.start();

	}

}
