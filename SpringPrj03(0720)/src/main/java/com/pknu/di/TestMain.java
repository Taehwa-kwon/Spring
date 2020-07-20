package com.pknu.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/pknu/di/beans/animal.xml");
		PetOwner person = (PetOwner) context.getBean("petOwner");
		//여기 person에 지금 cat이 반환되고있음
		
		//Dog dog = new Dog();이렇게 하거나 아니면 animal.xml에서 bean을 추가해주거나
		
		person.play();
		context.close();
				
	}
}
