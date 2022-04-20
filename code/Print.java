package LotteTicket;

import java.util.ArrayList;
import java.util.Scanner;

public class Print { // ��º�
	int entrancePrint(int position, ArrayList<OrderData> orderList) {

		ConvertOutput convert = new ConvertOutput();
		int totalPrice = 0;
		System.out.println("Ƽ�� �߱��� �����մϴ�. �����մϴ�.");
		System.out.println("---------------------�Ե�����-----------------------------");

		for (int column = 0; column <= position; column++) {

			String ticketClass = convert.convertTicketClass(orderList.get(column).getTicketClass());
			String ticketType = convert.convertTicketType(orderList.get(column).getTicketType());
			String ageGroup = convert.convertAgeGroup(orderList.get(column).getAgeGroup());
			String preferClass = convert.convertPreferClass(orderList.get(column).getPreferClass());
			// ticketClass ticketType ageGroup ticketCount price preferClass
			System.out.println(ticketClass + "\t" + ticketType + "\t" + ageGroup + "\t"
					+ orderList.get(column).getTicketCount() + "��\t" + orderList.get(column).getPrice() + "��\t*" + preferClass);

		}

		return 2;
	}

	int continuePrint(int position, ArrayList<OrderData> orderList) {
		
		System.out.println("��� �߱� �Ͻðڽ��ϱ�?");
		System.out.println("1. Ƽ�� �߱�");
		System.out.println("2. ����");
		Scanner scan = new Scanner(System.in);
		int continueSelect = scan.nextInt();

		if (continueSelect == 1) {
			return 0;
		} else if (continueSelect == 2) {
			int reset;
			reset = entrancePrint(position, orderList);
			return reset;
		} else if (continueSelect == 33) { // ������ ��ȣ 33�� ������ �ý��� ����
			return 1;
		}
		return 0;
	}

	void companionPossible() {
		System.out.println("���������� ���� �� �ֽ��ϴ�.\n");
	}

	
}
