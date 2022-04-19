package LotteTicket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TicketSystem {

	Calendar cal = Calendar.getInstance();
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	Date today = new Date();
	int nowTime = Integer.parseInt(format.format(today));
	int companionIndex = 0;
	OrderData orderItem;
	ArrayList<OrderData> orderList;

	// ����ó��
	void errorMessagePrint() {
		System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���");
	}


	// ó����

	// �迭 ����
	void savedInforms(OrderData orderItem, ArrayList<OrderData> orderList) {

		orderList.add(orderItem);
	}

	// process
	void inputData(int position, int companionPrint, ArrayList<OrderData> orderList) {

		int manAge = 0;

		OrderData orderItem = new OrderData();
		InputData input = new InputData(); // �Էº�
		InputCalculate cal = new InputCalculate(); // ó����
		Print print = new Print(); // ��º�

		orderItem.ticketClass = input.orderTicketClass(); // �̿��
		orderItem.ticketType = input.orderTicketType(); // ����
		orderItem.citizenNum = input.orderCitizenNum(); // �ֹι�ȣ
		manAge = cal.calcAge(orderItem.citizenNum, nowTime); // �ֹι�ȣ -> ������
		orderItem.ageGroup = cal.calcAgeGroup(manAge); // ������ -> ���̱׷�
		
		orderItem.price = cal.calcPriceProcess(orderItem.ageGroup, orderItem.ticketClass, orderItem.ticketType);
		orderItem.ticketCount = input.orderTicketCount(0); // 3
		orderItem.price = cal.calcTicketCount(orderItem.ticketCount, orderItem.price); // 4
		orderItem.preferClass = input.orderPreferClass(0); // 5
		if (orderItem.preferClass != 1) { // ���� �������� �ִٸ� ���αݾ����� ����

			orderItem.price = cal.calcDiscount(orderItem.price, orderItem.preferClass, orderItem.ticketClass);
			companionIndex = orderItem.preferClass; // �����׿� ���� ������ ���

		} else { // �������� ���°��
			if (companionIndex == 2 || companionIndex == 3 || companionIndex == 4) {
				// ����1�ε� ������ �Ǵ� ������ (�����, ����������, �ް��庴)
				print.companionPossible(); // ���������� �����ϴٴ� �ȳ� ���
				companionPrint = 1; // ������ ĭ�� �������� ����ϴ� index ����
				orderItem.price = cal.calcDiscount(orderItem.price, companionIndex, orderItem.ticketClass); // �������αݾ����� ����
				companionIndex = 0; // ���������� ���� 1�α����� �ǹǷ� index�� �ٷ� 0���� �ٲ��ָ� �ȴ�.
			}
			//
		}
		if (companionPrint == 1) {
			orderItem.preferClass = 7; // ������������ ����
			companionPrint = 0;
		}
		savedInforms(orderItem, orderList);
	}


	void main() {
		int exitIndex = 0;
		do {

			int position = 0; // inputList �� �߰��� ���
			int companionPrint = 0; // �������� ����Ʈ ���� index
			OrderData orderItem = new OrderData();
			ArrayList<OrderData> orderList = new ArrayList<OrderData>();
			TicketSystem lt = new TicketSystem(); // void main �ֵ��� �ٱ������� �𸥴� , �˷��־�� ��
			Print print = new Print();

			while (exitIndex != 2) {

				orderItem = new OrderData();
				lt.inputData(position, companionPrint, orderList);
				// ������ ����
				exitIndex = print.continuePrint(position, companionPrint, orderList);
				position++; // �迭��ġ ����
				System.out.println("\n");

			}

		} while (exitIndex != 1);

	}

}
