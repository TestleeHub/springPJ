package spring.mvc.pj_lyw.dto;

public class NoticeDTO {
	int notice_id; // 공지사항 고유 번호
	String notice_title; // 공지사항 제목
	String notice_text; // 공지사항 내용
	
	public NoticeDTO() {
	}

	public NoticeDTO(int notice_id, String notice_title, String notice_text) {
		super();
		this.notice_id = notice_id;
		this.notice_title = notice_title;
		this.notice_text = notice_text;
	}

	public int getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_text() {
		return notice_text;
	}

	public void setNotice_text(String notice_text) {
		this.notice_text = notice_text;
	}

	@Override
	public String toString() {
		return "NoticeDTO [notice_id=" + notice_id + ", notice_title=" + notice_title + ", notice_text=" + notice_text
				+ "]";
	}
	
}
