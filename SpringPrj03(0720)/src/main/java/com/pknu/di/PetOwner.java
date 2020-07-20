package com.pknu.di;

public class PetOwner {
	// 필드
	private AnimalType animal;

	// 생성자
	public PetOwner(AnimalType animal) {
		this.animal = animal;
	}

	public void play() {
		animal.sound();
		
		
	}

	@Override
	public String toString() {
		return "PetOwner [animal=" + animal + "]";
	}
}