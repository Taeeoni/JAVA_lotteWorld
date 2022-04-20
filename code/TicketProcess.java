package LotteTicket;

import java.util.ArrayList;

public class TicketProcess {
	
	void inputData(int position, int companionPrint, ArrayList<OrderData> orderList) {
		TicketSystem system = new TicketSystem();
		int manAge = 0;

		OrderData orderItem = new OrderData();
		InputData input = new InputData(); // �Էº�
		InputCalculate cal = new InputCalculate(); // ó����
		Print print = new Print(); // ��º�
		SaveArray save = new SaveArray(); // �迭����

		orderItem.setTicketClass(input.orderTicketClass()); // �̿��
		orderItem.setTicketType(input.orderTicketType()); // ����
		orderItem.setCitizenNum(input.orderCitizenNum()); // �ֹι�ȣ
		manAge = cal.calcAge(orderItem.getCitizenNum(), system.nowTime); // �ֹι�ȣ -> ������
		orderItem.setAgeGroup(cal.calcAgeGroup(manAge)); // ������ -> ���̱׷�
		
		orderItem.setPrice(cal.calcPriceProcess(orderItem.getAgeGroup(), orderItem.getTicketClass(), orderItem.getTicketType()));
		orderItem.setTicketCount(input.orderTicketCount(0)); // 3
		orderItem.setPrice(cal.calcTicketCount(orderItem.getTicketCount(), orderItem.getPrice())); // 4
		orderItem.setPreferClass(input.orderPreferClass(0)); // 5
		if (orderItem.getPreferClass() != 1) { // ���� �������� �ִٸ� ���αݾ����� ����

			orderItem.setPrice(cal.calcDiscount(orderItem.getPrice(), orderItem.getPreferClass(), orderItem.getTicketClass()));
			system.companionIndex = orderItem.getPreferClass(); // �����׿� ���� ������ ���

		} else { // �������� ���°��
			if (system.companionIndex == 2 || system.companionIndex == 3 || system.companionIndex == 4) {
				// ����1�ε� ������ �Ǵ� ������ (�����, ����������, �ް��庴)
				print.companionPossible(); // ���������� �����ϴٴ� �ȳ� ���
				companionPrint = 1; // ������ ĭ�� �������� ����ϴ� index ����
				orderItem.setPrice(cal.calcDiscount(orderItem.getPrice(), system.companionIndex, orderItem.getTicketClass())); // �������αݾ����� ����
				system.companionIndex = 0; // ���������� ���� 1�α����� �ǹǷ� index�� �ٷ� 0���� �ٲ��ָ� �ȴ�.
			}
			//
		}
		if (companionPrint == 1) {
			orderItem.setPreferClass(7); // ������������ ����
			companionPrint = 0;
		}
		save.savedInforms(orderItem, orderList);
	}

}
