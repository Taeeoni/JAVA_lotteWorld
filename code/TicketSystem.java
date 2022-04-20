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

	void main() {
		int exitIndex = 0;
		do {
			int position = 0; // inputList 행 추가시 사용
			int companionPrint = 0; // 동반할인 프린트 여부 index
			OrderData orderItem = new OrderData();
			ArrayList<OrderData> orderList = new ArrayList<OrderData>();
			Print print = new Print();
			TicketProcess process = new TicketProcess();

			while (exitIndex != 2) {

				orderItem = new OrderData();
				process.inputData(position, companionPrint, orderList);
				// 고객정보 저장
				exitIndex = print.continuePrint(position, companionPrint, orderList);
				position++; // 배열위치 변경
				System.out.println("\n");

			}
			
			exitIndex = 0;

		} while (exitIndex != 1);

	}

}
