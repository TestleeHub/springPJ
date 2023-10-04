package spring.mvc.pj_lyw.dao;

import java.util.List;
import java.util.Map;

import spring.mvc.pj_lyw.dto.MemberDTO;
import spring.mvc.pj_lyw.dto.NoticeDTO;

public interface CommonDAO {
	// 회원가입 처리
	public int insertClientMember(MemberDTO dto);
	// 로그인 처리
	public boolean idPasswordChkClient(Map<String, Object> map);
	// 회원정보 인증 및 탈퇴 처리
	public int deleteClientMember(String strId);
	// 회원정보 인증 및 상세 페이지
	public MemberDTO getClientMemberDetail(String strId);
	// 회원정보 수정 처리
	public int updateClientMember(MemberDTO dto);
	
	// 회원가입 처리
	public int insertExpertMember(MemberDTO dto);
	// 로그인 처리
	public boolean idPasswordChkExpert(Map<String, Object> map);
	// 회원정보 인증 및 탈퇴 처리
	public int deleteExpertMember(String strId);
	// 회원정보 인증 및 상세 페이지
	public MemberDTO getExpertMemberDetail(String strId);
	// 회원정보 수정 처리
	public int updateExpertMember(MemberDTO dto);
	
	// 공지사항 조회
	public List<NoticeDTO> noticeList(Map<String, Object> map);
	// 공지사항 갯수 조회
	public int noticeCnt();
	// 공지사항 등록
	public int insertNotice(NoticeDTO dto);
	// 공자사항 디테일 호출
	public NoticeDTO getNoticeDetail(int notice_id);
	// 공지사항 수정
	public int updateNotice(NoticeDTO dto);
	// 공지사항 삭제
	public int deleteNotice(int notice_id);
	
	// 이메일 전송
	public String sendEmail(String key, String email);
	// 이메일 키 확인
	public int selectKey(String key);
	// 이메일 확인 완료후 업그레이드
	public int updateClientGrade(String key);
	public int updateExpertGrade(String key);
}
