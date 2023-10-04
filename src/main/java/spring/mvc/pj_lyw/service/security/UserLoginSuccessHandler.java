package spring.mvc.pj_lyw.service.security;

import java.io.IOException;
import java.util.Iterator;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import spring.mvc.pj_lyw.dto.UserVO;

// 로그인 성공시 작동
@Service
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {
	@Inject
	SqlSession sqlSession;
	
	public UserLoginSuccessHandler() {
	}
	
	public UserLoginSuccessHandler(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.out.println("<<< UserLoginSuccessHandler - onAuthenticationSuccess 진입 >>>");

		UserVO vo = (UserVO) authentication.getPrincipal();
		System.out.println("UserVO : " + vo.getUsername());
		
		String msg = authentication.getName() + "님 환영합니다.";
		String authority = "";
		
		for (Iterator<GrantedAuthority> iterator = vo.getAuthorities().iterator(); iterator.hasNext();) {
			GrantedAuthority type = (GrantedAuthority)iterator.next();
			authority = type.getAuthority();
		}
		System.out.println("authority = " + authority);

		request.setAttribute("msg", msg);
		request.getSession().setAttribute("SessionId", authentication.getName()); // 세션추가
		request.getSession().setAttribute("SessionAuthority", authority);
		
		int grade = 0;
		String viewPage = "/main.do";

		request.getRequestDispatcher(viewPage).forward(request, response);
	}

}
