package LotteTicket;

import java.util.ArrayList;

public class TicketLogic {
	
	void logic(int position, ArrayList<OrderData> orderList) {
		
		int manAge = 0;
		int companionIndex = 0;
		int companionPrint = 0;

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
			//
		}
		
		if (companionPrint == 1) {
			orderItem.setPreferClass(7); // ������������ ����
			companionPrint = 0;
		}
		
		savedInforms(orderItem, orderList); // �迭 ����
	}
	
	
	void savedInforms(OrderData orderItem, ArrayList<OrderData> orderList) {

		orderList.add(orderItem);
	}

}
