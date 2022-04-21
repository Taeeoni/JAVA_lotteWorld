package LotteTicket;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TicketSystem {
	
	//�ʵ庯�� ����
	int exitIndex;
	int position;
	int companionPrint;
	boolean indexTitlePrint;
	int manAge;
	int companionIndex;

	
	public TicketSystem() { // �⺻ ������ , �ν��Ͻ��� �ʱ�ȭ
		
		exitIndex = 0; // ���α׷� ���� index
		position = 0; // inputList �� �߰��� ���
		companionPrint = 0; // �������� ����Ʈ ���� index
		indexTitlePrint = true; // csv ���� �������� ����κ� write index
		manAge = 0; // ������ 
		companionIndex = 0; // �������� index
		
	} 

	void main() throws IOException {
		
		do {

			ArrayList<OrderData> orderList = new ArrayList<OrderData>(); // arraylist reset
			Print print = new Print(); 
			position = 0;
			
			while (exitIndex != 2 && exitIndex != 1) { // exitIndex 0�� ���ο��� �߱� , 1�� �ý�������, 2�� ��ӹ߱� 

				logic(position, orderList);
				// ������ ����
				
				if(indexTitlePrint == true) { // �ý��� ó�� �����ߴٴ� index
					print.printTitle(); // csv���� �׸��(������) �ۼ� �޽��
					indexTitlePrint = false;
				}
				
				exitIndex = print.continuePrint(position, orderList); // ���� �Է��� ���� print 
				position++; // �迭��ġ ����
				System.out.println("\n");

			}
			
			if(exitIndex != 1) {
				exitIndex = 0; // 0���� �ٲ��־�� �ٽ� while ������ ����.
			}
			
		} while (exitIndex != 1);

	}
	
	void logic(int position, ArrayList<OrderData> orderList) {
		


		OrderData orderItem = new OrderData();
		InputData input = new InputData(); // �Էº�
		InputCalculate cal = new InputCalculate(); // ó����
		Print print = new Print(); // ��º�

		orderItem.setTicketClass(input.orderTicketClass()); // �̿��
		orderItem.setTicketType(input.orderTicketType()); // ����
		orderItem.setCitizenNum(input.orderCitizenNum()); // �ֹι�ȣ
		manAge = cal.calcAge(orderItem.getCitizenNum()); // �ֹι�ȣ -> ������
		orderItem.setAgeGroup(cal.calcAgeGroup(manAge)); // ������ -> ���̱׷�
		
		orderItem.setPrice(cal.calcPriceProcess(orderItem.getAgeGroup(), orderItem.getTicketClass(), orderItem.getTicketType()));
		orderItem.setTicketCount(input.orderTicketCount()); // 3
		orderItem.setPrice(cal.calcTicketCount(orderItem.getTicketCount(), orderItem.getPrice())); // 4
		orderItem.setPreferClass(input.orderPreferClass()); // 5
		
		if (orderItem.getPreferClass() != 1) { // ���� �������� �ִٸ� ���αݾ����� ����

			orderItem.setPrice(cal.calcDiscount(orderItem.getPrice(), orderItem.getPreferClass(), orderItem.getTicketClass()));
			companionIndex = orderItem.getPreferClass(); // �����׿� ���� ������ ���

		} else { // �������� ���°��
			if (companionIndex == 2 || companionIndex == 3 || companionIndex == 4) {
				// ����1�ε� ������ �Ǵ� ������ (�����, ����������, �ް��庴)
				print.companionPossible(); // ���������� �����ϴٴ� �ȳ� ���
				companionPrint = 1; // ������ ĭ�� �������� ����ϴ� index ����
				orderItem.setPrice(cal.calcDiscount(orderItem.getPrice(), companionIndex, orderItem.getTicketClass())); // �������αݾ����� ����
				companionIndex = 0; // ���������� ���� 1�α����� �ǹǷ� index�� �ٷ� 0���� �ٲ��ָ� �ȴ�.
			}
			
		}
		
		if (companionPrint == 1) {
			orderItem.setPreferClass(7); // ������������ ����
			companionPrint = 0;
		}
		
		savedInforms(orderItem, orderList); // �迭 ����
	}
	
	
	void savedInforms(OrderData orderItem, ArrayList<OrderData> orderList) {

		orderList.add(orderItem); // orderItem �� ������� orderList�� ���� 
	}

	

}
