package com.pknu.aop;

public class PetOwner {
  
	
	private AnimalType animal;

	public PetOwner(AnimalType animal) {
		this.animal = animal;
		System.out.println("AnimalType"+animal);
		System.out.println("AnimalType"+this.animal);
	}
   public void play() {
      animal.sound();
   }
}