package LotteTicket;

public class OrderData {
	private int ticketClass; // ���� int (1. �����̿�� , 2. ��ũ�̿��)
	private int ticketType; // Ƽ��Ÿ�� int (1. 1�ϱ�, 2. After4)
	private String citizenNum; // �ֹι�ȣ String 
	private int ticketCount; // �ֹ����� int (�ִ� 10��)
	private int price;
	private int preferClass; // ������ int 
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
