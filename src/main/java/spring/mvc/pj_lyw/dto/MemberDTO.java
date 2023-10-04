package spring.mvc.pj_lyw.dto;

import java.sql.Date;

public class MemberDTO {
	private int member_id; // 멤버 고유 번호
	private String nickname; // 닉네임
	private String email; // 이메일
	private String password; // 암호
	private String phone; // 전화번호
	private Date join_date;// 가입일
	private String key; // 이메일인증
	private String enabled; // 이메일 인증 여부
	private String authority; // 권한
	

	public MemberDTO() {
	}
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setClient_id(int member_id) {
		this.member_id = member_id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public MemberDTO(int member_id, String nickname, String email, String password, String phone, Date join_date) {
		super();
		this.member_id = member_id;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.join_date = join_date;
	}

	@Override
	public String toString() {
		return "MemberDTO [member_id=" + member_id + ", nickname=" + nickname + ", email=" + email + ", password="
				+ password + ", phone=" + phone + ", join_date=" + join_date + ", key=" + key + ", enabled=" + enabled
				+ "]";
	}

}
