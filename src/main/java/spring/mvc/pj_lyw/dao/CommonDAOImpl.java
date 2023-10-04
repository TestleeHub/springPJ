package spring.mvc.pj_lyw.dao;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import spring.mvc.pj_lyw.dto.MemberDTO;
import spring.mvc.pj_lyw.dto.NoticeDTO;
import spring.mvc.pj_lyw.util.SettingValues;

@Repository
public class CommonDAOImpl implements CommonDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public int insertClientMember(MemberDTO dto) {
		return sqlSession.getMapper(CommonDAO.class).insertClientMember(dto);
	}

	@Override
	public boolean idPasswordChkClient(Map<String, Object> map) {
		boolean result = false;
		
		int Cnt = sqlSession.selectOne("spring.mvc.pj_lyw.dao.CommonDAO.idPasswordChkClient", map);
		if(Cnt == 1) result = true;
		
		return result;
	}

	@Override
	public int deleteClientMember(String strId) {
		return sqlSession.getMapper(CommonDAO.class).deleteClientMember(strId);
	}

	@Override
	public MemberDTO getClientMemberDetail(String strId) {
		return sqlSession.getMapper(CommonDAO.class).getClientMemberDetail(strId);
	}

	@Override
	public int updateClientMember(MemberDTO dto) {
		return sqlSession.getMapper(CommonDAO.class).updateClientMember(dto);
	}

	@Override
	public int insertExpertMember(MemberDTO dto) {
		return sqlSession.getMapper(CommonDAO.class).insertExpertMember(dto);
	}

	@Override
	public boolean idPasswordChkExpert(Map<String, Object> map) {
		boolean result = false;
		
		int Cnt = sqlSession.selectOne("spring.mvc.pj_lyw.dao.CommonDAO.idPasswordChkExpert", map);
		if(Cnt == 1) result = true;
		
		return result;
	}

	@Override
	public int deleteExpertMember(String strId) {
		return sqlSession.getMapper(CommonDAO.class).deleteExpertMember(strId);
	}

	@Override
	public MemberDTO getExpertMemberDetail(String strId) {
		return sqlSession.getMapper(CommonDAO.class).getExpertMemberDetail(strId);
	}

	@Override
	public int updateExpertMember(MemberDTO dto) {
		return sqlSession.getMapper(CommonDAO.class).updateExpertMember(dto);
	}

	@Override
	public List<NoticeDTO> noticeList(Map<String, Object> map) {
		return sqlSession.getMapper(CommonDAO.class).noticeList(map);
	}

	@Override
	public int noticeCnt() {
		return sqlSession.getMapper(CommonDAO.class).noticeCnt();
	}

	@Override
	public int insertNotice(NoticeDTO dto) {
		return sqlSession.getMapper(CommonDAO.class).insertNotice(dto);
	}

	@Override
	public NoticeDTO getNoticeDetail(int notice_id) {
		return sqlSession.getMapper(CommonDAO.class).getNoticeDetail(notice_id);
	}

	@Override
	public int updateNotice(NoticeDTO dto) {
		return sqlSession.getMapper(CommonDAO.class).updateNotice(dto);
	}

	@Override
	public int deleteNotice(int notice_id) {
		return sqlSession.getMapper(CommonDAO.class).deleteNotice(notice_id);
	}

	@Override
	public String sendEmail(String key, String email) {
		final String username = SettingValues.ADMIN; // 네이버의 이메일 ID : @naver.com 삭제
		final String password = SettingValues.PW; // 네이버의 비밀번호
		final String host = "smtp.naver.com"; // 구글일 경우 smtp.gmail.com
		int port = 465;
		
		// 메일 내용
		String recipient = "sch3856@naver.com"; // 리시버 주소
		String subject = "회원가입 인증 메일"; // 메일제목 입력
		String content = "회원가입을 축하드립니다. 링크를 눌러서 회원가입을 완료하세요."
				+ "<a href='http://localhost/pj_lyw/emailChkAction.do?key=" + key + "'>링크 </a>";
		
		Properties props = System.getProperties();
		
		// 정보를 담기 위한 객체 생성
		// SMTP 서버 정보 설정
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);
		
		// 세션 생성
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			String name = username;
			String pw = password;
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(name, pw);
			}
		});
		
		session.setDebug(true);
		
		try {
			Message mimeMessage = new MimeMessage(session); // MimeMessaget 생성
			mimeMessage.setFrom(new InternetAddress("sch3856@naver.com")); // 발신자 셋팅, 보내는 사람의 이메일 주소를 한번 더 입력(풀 주소)
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			mimeMessage.setSubject(subject);
			mimeMessage.setContent(content, "text/html; charset=utf-8");
			Transport.send(mimeMessage);
			System.out.println("<<<Email SEND>>>");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return "";
	}

	@Override
	public int selectKey(String key) {
		return sqlSession.getMapper(CommonDAO.class).selectKey(key);
	}

	@Override
	public int updateClientGrade(String key) {
		return sqlSession.getMapper(CommonDAO.class).updateClientGrade(key);
	}
	
	@Override
	public int updateExpertGrade(String key) {
		return sqlSession.getMapper(CommonDAO.class).updateExpertGrade(key);
	}
	
}
