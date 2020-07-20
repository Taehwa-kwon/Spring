package com.pknu.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	
	//AOP
	//Aspect Oriented Programming : 관점지향
	//관점지향이란 사전,사후에 필요한 코딩을 자동으로 작동하게 하는것 . PointCut 
	
	//빵또아를 생각하기. A라는 코딩을 하기에 앞서    |  A  | 앞뒤로 뭐 로그에 관한 설정 등등 여러 설정들을 하게되는데
	//그러한 설정들을 미리 만들어두고 | Random | 이렇게 생성해놓고 Random 인터페이스를 만든다
	//그리고 그 인터페이스에 A,B,C 아무거나 와서 껴놓을수 있다.
	
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/pknu/aop/beans/animal.xml");
		PetOwner person = (PetOwner) context.getBean("petOwner");
		
		//Dog dog = new Dog();이렇게 하거나 아니면 animal.xml에서 bean을 추가해주거나
		
		person.play();
		context.close();
				
		
	}
}
