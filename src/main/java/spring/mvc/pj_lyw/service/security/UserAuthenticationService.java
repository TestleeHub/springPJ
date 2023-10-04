package spring.mvc.pj_lyw.service.security;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import spring.mvc.pj_lyw.dto.MemberDTO;
import spring.mvc.pj_lyw.dto.UserVO;

//로그인 인증처리 클래스 : 비밀번호인증, 로그인 성공, 실패, 권한없음을 판단 
@Service
public class UserAuthenticationService implements UserDetailsService{
	@Inject
	SqlSession sqlSession;
	
	public UserAuthenticationService() {}
	
	public UserAuthenticationService(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	/* 핵심코드
	    * 로그인 인증을 처리하는 메서드
	    * 1) 매개변수 username을 id로 수정
	    * 2) 매개변수로 전달된 아이디와 일치하는 레코드를 읽어온다.
	    * 3) 테이블의 암호화된 비밀번호와 사용자가 입력한 비밀번호를 내부적으로 비교처리
	    * 4) 정보가 없으면 예외처리를 발생시키고, 있으면 해당정보를 dto로 리턴한다.
	    * 5) 로그인 성공이면 UserLoginSeccessHandler로 이동
	    *    로그인 실패이면 UserLoginFailureHandler로 이동
	    *    권한이 없으면 403에러, UserDeniedHandler로 이동
	   */
	
	@Override
	public UserDetails loadUserByUsername(String id) 
			throws UsernameNotFoundException {

		System.out.println("<<<UserAuthenticationService - loadUserByUsername 진입 >>> sqlSession=" + sqlSession);
		
		MemberDTO dto = null;
		String StrId = id;
		String role = "";
		dto = sqlSession.selectOne("spring.mvc.pj_lyw.dao.CommonDAO.getClientMemberDetail", StrId);
		System.out.println("클라이언트 로그인 체크 ==> id = " + id  + "dto = " + dto);
		
		if (dto == null) {
			dto = sqlSession.selectOne("spring.mvc.pj_lyw.dao.CommonDAO.getExpertMemberDetail", StrId);
			System.out.println("전문가 로그인 체크 ==> id = " + id  + "dto = " + dto);
			if(dto == null && !id.equals("admin")) {
				// 로그인인증 실패시 인위적으로 예외 생성해서 던진다.
				throw new UsernameNotFoundException(id);
			}else {
				role = "ROLE_EXPERT";
			}
		}else {
			role = "ROLE_CLIENT";
		}

		List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();

		if(!id.equals("admin"))
		authority.add(new SimpleGrantedAuthority(role)); // default 'ROLE_USER'
		else {
			dto = new MemberDTO();
			dto.setEmail("admin");
			dto.setPassword("$2a$10$y2d537GtFrh6oPJRoBPN3u3MefYmpC4eC6N3Cg9lZ5pJYlM4MPHBa");
			dto.setEnabled("1");
			authority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			System.out.println(dto);
		}
		// UserVO 클래스 먼저 생성후 return
		// 시큐리티 로그인에서 체크 : id, password, authority(ROLE_USER / ROLE_ADMIN),
		// enabled(이메일인증시 "1"로 update치며, 이메일인증후 시큐리티 적용)
		return new UserVO(dto.getEmail(), dto.getPassword(), dto.getEnabled().equals("1"), true, true, true, authority);
	}
}
