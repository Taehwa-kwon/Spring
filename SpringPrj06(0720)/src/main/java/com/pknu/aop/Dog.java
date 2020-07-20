package com.pknu.aop;

public class Dog implements AnimalType {

	private String name;

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public void sound() {
		System.out.println(name+"이가 멍멍");

	}

}
