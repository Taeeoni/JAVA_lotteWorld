package LotteTicket;

public class OrderData {
	public int ticketClass; // 권종 int (1. 종합이용권 , 2. 파크이용권)
	public int ticketType; // 티켓타입 int (1. 1일권, 2. After4)
	public String citizenNum; // 주민번호 String 
	public int ticketCount; // 주문개수 int (최대 10개)
	public int price;
	public int preferClass; // 우대사항 int 
	public int ageGroup;
	
}
