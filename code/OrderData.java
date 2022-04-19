package LotteTicket;

public class OrderData {
	private int ticketClass; // 권종 int (1. 종합이용권 , 2. 파크이용권)
	private int ticketType; // 티켓타입 int (1. 1일권, 2. After4)
	private String citizenNum; // 주민번호 String 
	private int ticketCount; // 주문개수 int (최대 10개)
	private int price;
	private int preferClass; // 우대사항 int 
	private int ageGroup;
	
	public int getTicketClass() {
		return ticketClass;
	}
	public void setTicketClass(int ticketClass) {
		this.ticketClass = ticketClass;
	}
	public int getTicketType() {
		return ticketType;
	}
	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}
	public String getCitizenNum() {
		return citizenNum;
	}
	public void setCitizenNum(String citizenNum) {
		this.citizenNum = citizenNum;
	}
	public int getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPreferClass() {
		return preferClass;
	}
	public void setPreferClass(int preferClass) {
		this.preferClass = preferClass;
	}
	public int getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
	}
	
}
