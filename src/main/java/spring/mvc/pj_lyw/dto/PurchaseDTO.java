package spring.mvc.pj_lyw.dto;

import java.sql.Date;

public class PurchaseDTO {
	int purchase_id; // 구매 고유 번호
	int client_id; // 구매자 고유 번호
	int product_id; // 상품 고유 번호
	int price; // 상품 가격
	String state; // 상품 상태(구매중, 구매완료, 구매취소)
	Date purchase_date; // 구매일
	String productName; // 상품 명
	String productExplanation; // 상품 설명
	String expertName; // 판매자 이름
	String expertPhone; // 판매자 연락처
	String image; // 이미지 이름
	
	
	public PurchaseDTO() {
		// TODO Auto-generated constructor stub
	}

	public PurchaseDTO(int purchase_id, int client_id, int product_id, int price, String state, Date purchase_date) {
		super();
		this.purchase_id = purchase_id;
		this.client_id = client_id;
		this.product_id = product_id;
		this.price = price;
		this.state = state;
		this.purchase_date = purchase_date;
	}

	public PurchaseDTO(int purchase_id, int client_id, int product_id, int price, String state, Date purchase_date,
			String productName, String productExplanation, String expertName, String expertPhone, String image) {
		super();
		this.purchase_id = purchase_id;
		this.client_id = client_id;
		this.product_id = product_id;
		this.price = price;
		this.state = state;
		this.purchase_date = purchase_date;
		this.productName = productName;
		this.productExplanation = productExplanation;
		this.expertName = expertName;
		this.expertPhone = expertPhone;
		this.image = image;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductExplanation() {
		return productExplanation;
	}

	public void setProductExplanation(String productExplanation) {
		this.productExplanation = productExplanation;
	}

	public String getExpertName() {
		return expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}

	public String getExpertPhone() {
		return expertPhone;
	}

	public void setExpertPhone(String expertPhone) {
		this.expertPhone = expertPhone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "PurchaseDTO [purchase_id=" + purchase_id + ", client_id=" + client_id + ", product_id=" + product_id
				+ ", price=" + price + ", state=" + state + ", purchase_date=" + purchase_date + ", productName="
				+ productName + ", productExplanation=" + productExplanation + ", expertName=" + expertName
				+ ", expertPhone=" + expertPhone + ", image=" + image + "]";
	}
}
