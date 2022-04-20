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
			int position = 0; // inputList 행 추가시 사용
			int companionPrint = 0; // 동반할인 프린트 여부 index
			ArrayList<OrderData> orderList = new ArrayList<OrderData>(); // arraylist reset
			Print print = new Print(); 
			TicketLogic process = new TicketLogic();

			while (exitIndex != 2) {

				process.logic(position, orderList);
				// 고객정보 저장
				exitIndex = print.continuePrint(position, orderList);
				position++; // 배열위치 변경
				System.out.println("\n");

			}
			
			exitIndex = 0;

		} while (exitIndex != 1);

	}

}
