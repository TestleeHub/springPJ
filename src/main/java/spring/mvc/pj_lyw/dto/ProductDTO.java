package spring.mvc.pj_lyw.dto;

import java.sql.Date;

public class ProductDTO {
	int product_id; // 상품 고유 번호
	int expert_id; // 전문가 고유 번호
	String name; // 상품 이름
	int price; // 상품 가격
	String explanation; // 상품 설명
	String description; // 상품 상세 설명
	int confirmcnt; // 구매 확정 갯수
	int cancelcnt; // 구매 취소 갯수
	int buycnt; // 구매 진행중 갯수
	String image; // 이미지 이름
	String category; // 카테고리
	Date reg_date; // 등록일
	String wished; // 찜여부

	public ProductDTO() {	}

	public ProductDTO(int product_id, int expert_id, String name, int price, String explanation, String description, String image,
			Date reg_date) {
		super();
		this.product_id = product_id;
		this.expert_id = expert_id;
		this.name = name;
		this.price = price;
		this.explanation = explanation;
		this.description = description;
		this.image = image;
		this.reg_date = reg_date;
	}
	
	public ProductDTO(int product_id, int expert_id, String name, int price, String explanation, String description, String image,
			Date reg_date, String wished) {
		super();
		this.product_id = product_id;
		this.expert_id = expert_id;
		this.name = name;
		this.price = price;
		this.explanation = explanation;
		this.description = description;
		this.image = image;
		this.reg_date = reg_date;
		this.wished = wished;
	}

	public ProductDTO(int product_id, int expert_id, String name, int price, String explanation, String description,
			int confirmcnt, int cancelcnt, int buycnt, String image, Date reg_date) {
		super();
		this.product_id = product_id;
		this.expert_id = expert_id;
		this.name = name;
		this.price = price;
		this.explanation = explanation;
		this.description = description;
		this.confirmcnt = confirmcnt;
		this.cancelcnt = cancelcnt;
		this.buycnt = buycnt;
		this.image = image;
		this.reg_date = reg_date;
	}
	
	public String getWished() {
		return wished;
	}

	public void setWished(String wished) {
		this.wished = wished;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public int getConfirmcnt() {
		return confirmcnt;
	}

	public void setConfirmcnt(int confirmcnt) {
		this.confirmcnt = confirmcnt;
	}

	public int getCancelcnt() {
		return cancelcnt;
	}

	public void setCancelcnt(int cancelcnt) {
		this.cancelcnt = cancelcnt;
	}

	public int getBuycnt() {
		return buycnt;
	}

	public void setBuycnt(int buycnt) {
		this.buycnt = buycnt;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getExpert_id() {
		return expert_id;
	}

	public void setExpert_id(int expert_id) {
		this.expert_id = expert_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "ProductDTO [product_id=" + product_id + ", expert_id=" + expert_id + ", name=" + name + ", price="
				+ price + ", explanation=" + explanation + ", description=" + description + ", confirmcnt=" + confirmcnt
				+ ", cancelcnt=" + cancelcnt + ", buycnt=" + buycnt + ", image=" + image + ", category=" + category
				+ ", reg_date=" + reg_date + ", wished=" + wished + "]";
	}

}
