package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
/*요청 = request 이다. 주소창에 검색을 하면 / << request 가 실행이 된다. 
 * 1.처음 호출은 / < home.jsp로 실행된다. 근데 home 이 실행하기전에    dispatcher에서 authInterceptor의 클래스를 찾아간다. 그럼 preHanler메소드가 작동된다.
 * 2.exclude-mapping /resources/**에 있는것은 제외된다.
 * 3.그런데 login.jsp가 실행된다.  이유는 
 * 4.홈페이지를 계속 이동해도 preHandle이 실행되고 session정보를 가지고 있으니깐 아무문제가 없다.
 * 세션이 로그인 내용이 있는지 없는지 검토하고  
	
*/	
	//컨트롤러 보다 먼저 수행되는 메소드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle : " + request.getRequestURI());
		
		switch(request.getRequestURI()) {//현재 파일 정보 
		case "/login":  //여기 case에 있는곳을 빼고 체크해라
		case "/loginProcess":
			return true; //여기 case에 있는곳을 빼고 체크해라 return true면 원래 경로로  false 면 따른곳으로 터진다.
		}
		
		//session 객체를 가지고 온다. 세션이랑 즉 통로 . 서버랑의 통로가 즉 세션 ( 서버와 클라이언트 사이의 어떤 공간) 
		// 그 공간안에 login이 있나없나느 체크할 수 있다. 값이 있으면 true 고 없으면 false 고  
		HttpSession session = request.getSession();
		//로그인 처리를 담당하는 사용자 정보를 담고 있는 객체를 가져온다.
		Object obj = session.getAttribute("login");
		
		if(obj==null) {//null이라면 로그인내용이없다는거니깐 sendRedirect로 보낸다. 
			response.sendRedirect("/login"); 
			return false; //더이상 컨트롤러 요청으로 가지 않도록 false 를 리턴한다. 내가 말한 /login으로 가라 .
		}
		return true;//preHandle의 return 은 컨트롤러 요청 URI 로 가도 되는지 허가하는 의미
	}
	
	//컨트롤러가 수행 되고 화면이 실행되기 직전에 실행되는 메소드 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	

}
