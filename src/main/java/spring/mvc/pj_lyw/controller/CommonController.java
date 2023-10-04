package spring.mvc.pj_lyw.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.pj_lyw.service.CommonService;

@Controller
public class CommonController {
	@Inject
	CommonService service;
	
	@RequestMapping (value = "main.do")
	public void main(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		req.getRequestDispatcher("/productlist.cu").forward(req, res);
	}
	
	@RequestMapping (value = "login.do")
	public String login(HttpServletRequest req, Model model)
			throws ServletException, IOException{
		return"common/login/login";
	}
	@RequestMapping (value = "loginAction.do")
	public String loginAction(HttpServletRequest req, Model model)
			throws ServletException, IOException{
		service.loginAction(req, model);
		return"common/login/loginAction";
	}
	@RequestMapping (value = "logout.do")
	public void logout(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		req.getSession().invalidate();
		req.getRequestDispatcher("/productlist.cu").forward(req, res);
		return ;
	}
	@RequestMapping (value = "join.do")
	public String join(HttpServletRequest req, Model model)
			throws ServletException, IOException{
		return"common/join/join";
	}
	@RequestMapping (value = "joinAction.do")
	public String joinAction(HttpServletRequest req, Model model)
			throws ServletException, IOException{
		service.signInAction(req, model);
		return"common/join/joinAction";
	}
	@RequestMapping (value = "updatepwdChk.do")
	public String updatepwdChk(HttpServletRequest req, Model model)
			throws ServletException, IOException{
		return"common/join/updatepwdChk";
	}
	@RequestMapping (value = "updatepwdChkAction.do")
	public String updatepwdChkAction(HttpServletRequest req, Model model)
			throws ServletException, IOException{
		service.passwordChk(req, model);
		return"common/join/updatepwdChkAction";
	}
	@RequestMapping (value = "memberUpdate.do")
	public String memberUpdate(HttpServletRequest req, Model model)
			throws ServletException, IOException{
		String SessionAuthority = (String)req.getSession().getAttribute("SessionAuthority");
		service.modifyDetailAction(req, model);
		if(SessionAuthority.equals("expert")) return"expert/mypage/memberUpdate";
		else return "customer/mypage/memberUpdate";
		
	}
	@RequestMapping (value = "memberUpdateAction.do")
	public String memberUpdateAction(HttpServletRequest req, Model model)
			throws ServletException, IOException{
		service.modifyMemberAction(req, model);
		return"common/join/updateMemberAction";
	}
	@RequestMapping (value = "memberDeleteAction.do")
	public String memberDeleteAction(HttpServletRequest req, Model model)
			throws ServletException, IOException{
		service.deleteMemberAction(req, model);
		return"common/join/deleteMemberAction";
	}
	@RequestMapping (value = "notice.do")
	public String notice(HttpServletRequest req, Model model)
			throws ServletException, IOException{
		service.noticeList(req, model);
		return"common/notice/noticeList";
	}
	@RequestMapping (value = "addNotice.do")
	public String addNotice(HttpServletRequest req, Model model)
			throws ServletException, IOException{
		return"common/notice/addNotice";
	}
	@RequestMapping (value = "addNoticeAction.do")
	public String addNoticeAction(HttpServletRequest req, Model model)
			throws ServletException, IOException{
		service.addNotice(req, model);
		return"common/notice/addNoticeAction";
	}
	@RequestMapping (value = "noticeDetail.do")
	public String noticeDetail(HttpServletRequest req, Model model)
			throws ServletException, IOException{
		service.noticeDetail(req, model);
		return"common/notice/noticeDetail";
	}
	@RequestMapping (value = "updateNoticeAction.do")
	public String updateNoticeAction(HttpServletRequest req, Model model)
			throws ServletException, IOException{
		service.updateNoticeAction(req, model);
		return"common/notice/updateNoticeAction";
	}
	@RequestMapping (value = "deleteNoticeAction.do")
	public String deleteNoticeAction(HttpServletRequest req, Model model)
			throws ServletException, IOException{
		service.deleteNoticeAction(req, model);
		return"common/notice/deleteNoticeAction";
	}
	@RequestMapping(value = "emailChkAction.do")
	public String emailChkAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.emailChkAction(req, model);
		return "common/join/emailChkAction";
	}
	@RequestMapping(value = "accessDenied.do")
	public String accessDenied(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		
		return "common/accessDenied";
	}
}
