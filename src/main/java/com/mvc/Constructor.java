package com.mvc;

public class Constructor {

//	public void Constructor() {
//		얘는 그냥 첫번째 글자가 대문자인 함수임
//	}
	
	int num;
	
	public Constructor() {	// 생성자 이름은 대소문자도 틀리면 안됨
		System.out.println(num);
	}
	
	public Constructor(int num) {
		System.out.println(num);
		this.num = num;
	}
	
//	int num;		// 얘네 먼저 로딩 되고 생성자 생성되서 코드 순서가 이래도 실행됨, 그런데 맴버변수는 생성자 위에 있는것이 규칙이라서 이렇게 안씀
//	void test() {
//		System.out.println("이미 머리속에 있어서 생성자에서 호출됨");
//	}
}

class Execute {
	public static void main(String[] args) {
		Constructor c = new Constructor(100);	// 만약에 Constructor(int num)에 this.num = num 없으면 출력만 하고 끝나서 28째줄에 c.num은 0임
		System.out.println(c.num);
	}
}