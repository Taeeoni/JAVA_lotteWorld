package LotteTicket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TicketSystem {


	void main() {
		int exitIndex = 0;
		do {
			int position = 0; // inputList �� �߰��� ���
			int companionPrint = 0; // �������� ����Ʈ ���� index
			ArrayList<OrderData> orderList = new ArrayList<OrderData>(); // arraylist reset
			Print print = new Print(); 
			TicketLogic process = new TicketLogic();

			while (exitIndex != 2) {

				process.logic(position, orderList);
				// ������ ����
				exitIndex = print.continuePrint(position, orderList);
				position++; // �迭��ġ ����
				System.out.println("\n");

			}
			
			exitIndex = 0;

		} while (exitIndex != 1);

	}

}
