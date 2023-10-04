package spring.mvc.pj_lyw.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface CommonService {
	// ID 중복 확인 처리
	public void idConfirmAction(HttpServletRequest req, Model model) 
		throws ServletException, IOException;
	// 회원가입 처리
	public void signInAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 로그인 처리
	public void loginAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 회원정보 인증 및 탈퇴 처리
	public void deleteMemberAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 회원정보 인증 및 상세 페이지
	public void modifyDetailAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 회원정보 수정 처리
	public void modifyMemberAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 회원 정보 수정시 패스워드 체크
	public void passwordChk(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 공지사항 목록 조회
	public void noticeList(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 공지사항 등록
	public void addNotice(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 공지사항 수정 에디터 호출
	public void noticeDetail(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 공지사항 수정 
	public void updateNoticeAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 공지사항 삭제
	public void deleteNoticeAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 이메일 체크
	public void emailChkAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
}
