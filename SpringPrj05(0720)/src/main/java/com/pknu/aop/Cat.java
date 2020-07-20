package com.pknu.aop;

public class Cat implements AnimalType {

	private String name;

	public void setName(String name) {
		this.name = name;
		System.out.println("Cat"+name);
	}
	

	@Override
	public void sound() {
		System.out.println(name+"이가 야옹");
	}

}
