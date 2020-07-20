package com.pknu.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PetOwner {
  
	//bean목록에서 생성자에 필요한 class를 자동으로 찾아서 삽입 
	//필드      Autowired : type이 같은 bean을 자동 주입한다. 근데 id가 다를수가 있으니깐 id를 value에 지정해준다.
	//Qualifier(value="cat") 인스턴스 id로 검색
	
	
	  // 방법1
	
	  @Autowired 
	  @Qualifier(value="dog") //이것은 qualifier의 value를 보고  가능, 빼도 id랑 value는 동일한것으로 취급
	 // @Qualifier("cat") //이것은 bean Id를 확인하고 가능
	   private AnimalType animal;
	
	//방법 2 
	//type대신에 name으로 의존성 주입
	
//	 @Resource(name="cat") 
//	 private AnimalType animal;
   
   public void play() {
      animal.sound();
   }

@Override
public String toString() {
	return "PetOwner [animal=" + animal + "]";
}
}