package spring.mvc.pj_lyw.dto;

import java.sql.Date;

public class ReviewDTO {
	int purchase_id; // 구매 고유 번호
	Date reg_date; // 등록일
	float grade = 0; // 등급
	String review_text = ""; // 리뷰 내용
	String nickname; // 닉네임
	float avg_grade; // 평균 등급
	
	public ReviewDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReviewDTO(int purchase_id, Date reg_date, float grade, String review_text, String nickname, float avg_grade) {
		super();
		this.purchase_id = purchase_id;
		this.reg_date = reg_date;
		this.grade = grade;
		this.review_text = review_text;
		this.nickname = nickname;
		this.avg_grade = avg_grade;
	}
	
	public ReviewDTO(float grade, String review_text) {
		super();
		this.grade = grade;
		this.review_text = review_text;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public String getReview_text() {
		return review_text;
	}

	public void setReview_text(String review_text) {
		this.review_text = review_text;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public float getAvg_grade() {
		return avg_grade;
	}

	public void setAvg_grade(float avg_grade) {
		this.avg_grade = avg_grade;
	}

	@Override
	public String toString() {
		return "ReviewDTO [purchase_id=" + purchase_id + ", reg_date=" + reg_date + ", grade=" + grade
				+ ", review_text=" + review_text + ", nickname=" + nickname + ", avg_grade=" + avg_grade + "]";
	}
}
