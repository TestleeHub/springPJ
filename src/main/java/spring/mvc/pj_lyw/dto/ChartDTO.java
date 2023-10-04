package spring.mvc.pj_lyw.dto;

public class ChartDTO {
	private String month; // 월
	public int confirmCnt; // 구매확정 갯수
	public int cancelCnt; // 구매취소 갯수
	public int buyCnt; // 구매완료(진행중) 갯수
	
	public ChartDTO() {	}
	
	public ChartDTO(String month, int confirmCnt, int cancelCnt, int buyCnt) {
		super();
		this.month = month;
		this.confirmCnt = confirmCnt;
		this.cancelCnt = cancelCnt;
		this.buyCnt = buyCnt;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getConfirmCnt() {
		return confirmCnt;
	}

	public void setConfirmCnt(int confirmCnt) {
		this.confirmCnt = confirmCnt;
	}

	public int getCancelCnt() {
		return cancelCnt;
	}

	public void setCancelCnt(int cancelCnt) {
		this.cancelCnt = cancelCnt;
	}

	public int getBuyCnt() {
		return buyCnt;
	}

	public void setBuyCnt(int buyCnt) {
		this.buyCnt = buyCnt;
	}

	@Override
	public String toString() {
		return "chartDTO [month=" + month + ", confirmCnt=" + confirmCnt + ", cancelCnt=" + cancelCnt + ", buyCnt="
				+ buyCnt + "]";
	}
}
