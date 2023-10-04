package spring.mvc.pj_lyw.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.pj_lyw.dao.CommonDAO;
import spring.mvc.pj_lyw.dto.MemberDTO;
import spring.mvc.pj_lyw.dto.NoticeDTO;
import spring.mvc.pj_lyw.page.Paging;
import spring.mvc.pj_lyw.util.EmailChkHandler;

@Service
public class CommonServiceImpl implements CommonService{
	@Inject
	CommonDAO dao;
	@Inject
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void noticeList(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		String pageNum = req.getParameter("pageNum");
		Paging paging = new Paging(pageNum);
		paging.setPageSize(5);
		int noticeCnt = dao.noticeCnt();
		paging.setTotalCount(noticeCnt);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", paging.getStartRow());
		map.put("EndRow", paging.getEndRow());
		
		List<NoticeDTO> dtoList = dao.noticeList(map);
		
		req.setAttribute("paging", paging);
		req.setAttribute("dtoList", dtoList);
	}

	@Override
	public void idConfirmAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		
	}

	@Override
	public void signInAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		
		String authority = req.getParameter("authority"); 
		dto.setPhone(req.getParameter("hp1") + "-" + req.getParameter("hp2") + "-" + req.getParameter("hp3"));
		dto.setEmail(req.getParameter("email1") + "@" + req.getParameter("email2"));
		dto.setNickname(req.getParameter("nickname"));
		System.out.println("암호화 전 비밀번호 : " + req.getParameter("password"));
		String encodedPassword = bCryptPasswordEncoder.encode(req.getParameter("password"));
		dto.setPassword(encodedPassword);
		dto.setAuthority(authority);
		System.out.println("암호화 후 비밀번호 : " + encodedPassword);
		
		// 시큐리티 - 이메일 인증키 추가
		String key = EmailChkHandler.getKey();
		dto.setKey(key);
		
		int insertCnt = 0;
		if(authority.equals("ROLE_CLIENT")) {
			insertCnt = dao.insertClientMember(dto);
		}
		else {
			insertCnt = dao.insertExpertMember(dto);
		}
		System.out.println("처리결과 insertCnt = " + insertCnt);
		
		// 시큐리티 - 회원가입 성공시 이메일 검증
		if (insertCnt == 1) {
			dao.sendEmail(key, dto.getEmail());
		}
		
		req.setAttribute("insertCnt", insertCnt);
	}

	@Override
	public void loginAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String login_authority = req.getParameter("login_authority");
		//관리자 로그인 여부 확인
		if(id.equals("admin") && password.equals("admin")) {
			HttpSession session = req.getSession();
			session.setAttribute("SessionId", id);
			session.setAttribute("SessionAuthority", "admin");
			System.out.println("관리자 로그인");
			return;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("strId", id);
		map.put("strPassword", password);
		
		System.out.println(login_authority);
		
		boolean loginResult = false;
		if(login_authority.equals("ROLE_CLIENT")) {
			loginResult = dao.idPasswordChkClient(map);
		}
		else {
			loginResult = dao.idPasswordChkExpert(map);
		}
		
		//세션
		if(loginResult) {
			HttpSession session = req.getSession();
			session.setAttribute("SessionId", id);
			session.setAttribute("SessionAuthority", login_authority);
		}
		
		//세션으로 로그인 여부 판단
		//req.setAttribute("loginResult", loginResult);
		System.out.println("로그인 처리결과 loginResult = " + loginResult);
		
		req.setAttribute("loginResult", loginResult);
	}

	@Override
	public void deleteMemberAction(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		String id = (String)req.getSession().getAttribute("SessionId");
		String authority = (String)req.getSession().getAttribute("SessionAuthority");
		
		int deleteCnt  = 0;
		
		if(authority.equals("ROLE_CLIENT")) {
			deleteCnt = dao.deleteClientMember(id);
		}
		else {
			deleteCnt = dao.deleteExpertMember(id);
		}
		
		if(deleteCnt == 1) {
			req.getSession().invalidate();
		}
		
		req.setAttribute("deleteCnt", deleteCnt);
	}

	@Override
	public void modifyDetailAction(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		String id = (String)req.getSession().getAttribute("SessionId");
		String authority = (String)req.getSession().getAttribute("SessionAuthority");
		
		MemberDTO dto = null;
		
		if(authority.equals("ROLE_CLIENT")) {
			dto = dao.getClientMemberDetail(id);
		}
		else {
			dto = dao.getExpertMemberDetail(id);
		}
		
		req.setAttribute("dto", dto);
	}

	@Override
	public void modifyMemberAction(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		
		String id = (String)req.getSession().getAttribute("SessionId");
		String authority = (String)req.getSession().getAttribute("SessionAuthority");
		dto.setPhone(req.getParameter("hp1") + "-" + req.getParameter("hp2") + "-" + req.getParameter("hp3"));
		dto.setEmail(req.getParameter("email"));
		dto.setNickname(req.getParameter("nickname"));
		dto.setPassword(req.getParameter("password"));
		
		int updateCnt = 0;
		if(authority.equals("ROLE_CLIENT")) {
			updateCnt = dao.updateClientMember(dto);
		}
		else {
			updateCnt = dao.updateExpertMember(dto);
		}
		
		req.setAttribute("updateCnt", updateCnt);
	
	}

	@Override
	public void passwordChk(HttpServletRequest req, Model model) throws ServletException, IOException {
		String id = (String)req.getSession().getAttribute("SessionId");
		String password = req.getParameter("password");
		String login_authority = (String)req.getSession().getAttribute("SessionAuthority");
		
		boolean ChkResult = false;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("strId", id);
		map.put("strPassword", password);
		
		if(login_authority.equals("ROLE_CLIENT")) {
			ChkResult = dao.idPasswordChkClient(map);
		}
		else {
			ChkResult = dao.idPasswordChkExpert(map);
		}
		
		//세션
		if(ChkResult) {
			HttpSession session = req.getSession();
			session.setAttribute("SessionId", id);
			session.setAttribute("SessionAuthority", login_authority);
		}
		
		System.out.println("비밀번호 체크 결과 ChkResult = " + ChkResult);
		
		req.setAttribute("ChkResult", ChkResult);
	}

	@Override
	public void addNotice(HttpServletRequest req, Model model) throws ServletException, IOException {
		String notice_title = req.getParameter("notice_title");
		String notice_text = req.getParameter("notice_text");
		
		NoticeDTO dto = new NoticeDTO();
		dto.setNotice_text(notice_text);
		dto.setNotice_title(notice_title);
		
		int insertCnt = dao.insertNotice(dto);
		
		req.setAttribute("insertCnt", insertCnt);
	}

	@Override
	public void noticeDetail(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		int notice_id = Integer.parseInt(req.getParameter("notice_id"));
		
		NoticeDTO dto = dao.getNoticeDetail(notice_id);
		
		req.setAttribute("dto", dto);
	}

	@Override
	public void updateNoticeAction(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		int notice_id = Integer.parseInt(req.getParameter("notice_id"));
		String notice_title = req.getParameter("notice_title");
		String notice_text = req.getParameter("notice_text");
		
		NoticeDTO dto = new NoticeDTO(notice_id, notice_title, notice_text);
		
		int updateCnt = dao.updateNotice(dto);
		
		req.setAttribute("updateCnt", updateCnt);
	}

	@Override
	public void deleteNoticeAction(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		int notice_id = Integer.parseInt(req.getParameter("notice_id"));
		
		int deleteCnt = dao.deleteNotice(notice_id);
		
		req.setAttribute("deleteCnt", deleteCnt);
	}

	@Override
	public void emailChkAction(HttpServletRequest req, Model model) throws ServletException, IOException {
		String key = req.getParameter("key");
		int selectCnt = dao.selectKey(key);

		if (selectCnt == 1) {
			int insertCnt = 0;
			if((insertCnt = dao.updateClientGrade(key)) == 0) {
				insertCnt = dao.updateExpertGrade(key);
			}
			model.addAttribute("insertCnt", insertCnt);
		}
	}
	
}
