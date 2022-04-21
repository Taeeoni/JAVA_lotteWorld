package LotteTicket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Print { // 출력부
	
	int totalPrice;
	int nowTime;

	public Print() {
		
		totalPrice = 0;
		nowTime = 0;
	}
	
	void printTitle() throws IOException {
		
		File file = new File("C:\\test\\lotteworldreport\\lottereport.csv");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		bw.write("날짜, 이용권, 권종, 연령구분, 수량, 가격, 우대사항");
		bw.newLine();
		bw.flush();
		bw.close();
		
	}
	
	
	
	int entrancePrint(int position, ArrayList<OrderData> orderList) throws IOException {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date today = new Date();
		nowTime = Integer.parseInt(format.format(today));
		ConvertOutput convert = new ConvertOutput();
		
		//String path = "C:\\test\\seoulapart\\listout.csv";
		//BufferedReader br = new BufferedReader(new FileReader(path));
		File file = new File("C:\\test\\lotteworldreport\\lottereport.csv");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); // append
		
		


		
		System.out.println("티켓 발권을 종료합니다. 감사합니다.");
		System.out.println("---------------------롯데월드-----------------------------");

		for (int column = 0; column <= position; column++) {

			String ticketClass = convert.convertTicketClass(orderList.get(column).getTicketClass());
			String ticketType = convert.convertTicketType(orderList.get(column).getTicketType());
			String ageGroup = convert.convertAgeGroup(orderList.get(column).getAgeGroup());
			String preferClass = convert.convertPreferClass(orderList.get(column).getPreferClass());
			// ticketClass ticketType ageGroup ticketCount price preferClass
			System.out.println(ticketClass + "\t" + ticketType + "\t" + ageGroup + "\t"
					+ orderList.get(column).getTicketCount() + "장\t" + orderList.get(column).getPrice() + "원\t*" + preferClass);
			
			bw.write(nowTime + "," + ticketClass + "," + ticketType + "," + ageGroup + "," 
					+ orderList.get(column).getTicketCount() + "," + orderList.get(column).getPrice() + "," + preferClass);
			
		}
		
		
		bw.flush();
		bw.close();

		return 2;
	}

	int continuePrint(int position, ArrayList<OrderData> orderList) throws IOException {
		
		System.out.println("계속 발권 하시겠습니까?");
		System.out.println("1. 티켓 발권");
		System.out.println("2. 종료");
		Scanner scan = new Scanner(System.in);
		int continueSelect = scan.nextInt();

		if (continueSelect == 1) {
			return 0;
		} else if (continueSelect == 2) {
			int reset;
			reset = entrancePrint(position, orderList);
			return reset;
		} else if (continueSelect == 33) { // 숨겨진 번호 33을 누르면 시스템 종료
			return 1;
		}
		return 0;
	}

	void companionPossible() {
		System.out.println("동반할인을 받을 수 있습니다.\n");
	}

	
}
