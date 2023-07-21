package com.mvc;

class Test {
	public String name;
	
	public Test(String name) {
		this.name = name;
		this.printName();	
		// 이거(8째줄)는 Constructor에 있는 printName 실행됨
		// 생성자 생성되기 전에 로딩 순서가 Test, Constructor라서 Test의 printName()은 숨어 있고 Constructor의 printName()이 위에 있어서?
	}
	
	public void printName() {
		System.out.println("아빠 : " + name);
	}
}

public class Constructor2 extends Test{		// 하나의 자바 파일에 퍼블릭 클래스는 딱 한개만 있어야됨
	public Constructor2(String name1) {	// 기본 생성자 없이 파라미터 받는 생성자를 만들면 기본 생성자는 자동으로 생성되지 않음
		super(name1);	// 상위 클래스의 생성자를 말함
	}
	
	public void printName() {
		super.printName();
		System.out.println("아들 : " + name);
	}
}

class Execute2 {
	public static void main(String[] args) {
		Constructor2 c2 = new Constructor2("류승호"); // 생성자가 생성되기 전에 Test, Constructor 순서로 로딩 먼저함
//		c2.printName();
	}
}