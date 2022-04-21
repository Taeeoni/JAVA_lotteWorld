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

		File file = new File("C:\\test\\lotteworldreport\\lotteReport.csv");
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

		// String path = "C:\\test\\seoulapart\\listout.csv";
		// BufferedReader br = new BufferedReader(new FileReader(path));
		File file = new File("C:\\test\\lotteworldreport\\lotteReport.csv");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); // append

		if (orderList.get(position).getTicketClass() == 33) {
			System.out.println("프로그램을 종료합니다.");
			return 1;
		} else {

			System.out.println("티켓 발권을 종료합니다. 감사합니다.");
			System.out.println("---------------------롯데월드-----------------------------");

			for (int column = 0; column <= position; column++) {

				String ticketClass = convert.convertTicketClass(orderList.get(column).getTicketClass());
				String ticketType = convert.convertTicketType(orderList.get(column).getTicketType());
				String ageGroup = convert.convertAgeGroup(orderList.get(column).getAgeGroup());
				String preferClass = convert.convertPreferClass(orderList.get(column).getPreferClass());
				// ticketClass ticketType ageGroup ticketCount price preferClass
				System.out.println(ticketClass + "\t" + ticketType + "\t" + ageGroup + "\t"
						+ orderList.get(column).getTicketCount() + "장\t" + orderList.get(column).getPrice() + "원\t*"
						+ preferClass);

				bw.write(nowTime + "," + ticketClass + "," + ticketType + "," + ageGroup + ","
						+ orderList.get(column).getTicketCount() + "," + orderList.get(column).getPrice() + ","
						+ preferClass);
				bw.newLine();

			}

			bw.flush();
			bw.close();
			printCsv(); // lotteReport.csv 파일의 상황을 출력하기 위한 메소드로 이동

			return 2;
		}
	}

	void printCsv() throws IOException { //lotteReport.csv 파일의 상황을 출
		
		File file = new File("C:\\test\\lotteworldreport\\lotteReport.csv");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		System.out.println("");
		System.out.println("--------------------- lotteReport --------------------------");
		
		while((line = br.readLine()) != null) {
			String[] lineSplit = line.split(",");	
			for(int i = 0; i < lineSplit.length; i++) {
				System.out.printf("%8s", lineSplit[i]);	
			}		
			System.out.println("");
		}
		System.out.println("------------------------------------------------------------");
		salesAnalysis();
	}
	
	
	void salesAnalysis() throws NumberFormatException, IOException {
		System.out.println("---------------------이용권 별 판매 현황-------------------------");
		int count1 = 0;
		int dayCount = 0;
		int after4Count = 0;
		int littleCount = 0;
		int babyCount = 0;
		int kidCount = 0;
		int teenCount = 0;
		int adultCount = 0;
		int oldCount = 0;
		int priceSum = 0;
		
		int count1P = 0;
		int dayCountP = 0;
		int after4CountP = 0;
		int littleCountP = 0;
		int babyCountP = 0;
		int kidCountP = 0;
		int teenCountP = 0;
		int adultCountP = 0;
		int oldCountP = 0;
		int priceSumP = 0;
		
		File file = new File("C:\\test\\lotteworldreport\\lotteReport.csv");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		int readLineCount = 0;
		
		while((line = br.readLine()) != null) {
			
			if(readLineCount >= 1) {
				String[] lineSplit2 = line.split(",");
	
				if(lineSplit2[1].equals("종합이용권")) {
					count1++;
					
					if(lineSplit2[2].equals("1Day")) {
						dayCount++;
					} else if(lineSplit2[2].equals("After4")) {
						after4Count++;
					}
					
					if(lineSplit2[3].equals("영유아")) {
						littleCount++;
					} else if(lineSplit2[3].equals("유아")) {
						babyCount++;
					} else if(lineSplit2[3].equals("어린이")) {
						kidCount++;
					} else if(lineSplit2[3].equals("청소년")) {
						teenCount++;
					} else if(lineSplit2[3].equals("성인")) {
						adultCount++;
					} else if(lineSplit2[3].equals("노인")) {
						oldCount++;
					}
					
					priceSum += Integer.parseInt(lineSplit2[5]);
					
				} else if(lineSplit2[1].equals("파크이용권")) {
					count1P++;
					
					if(lineSplit2[2].equals("1Day")) {
						dayCountP++;
					} else if(lineSplit2[2].equals("After4")) {
						after4CountP++;
					}
					
					if(lineSplit2[3].equals("영유아")) {
						littleCountP++;
					} else if(lineSplit2[3].equals("유아")) {
						babyCountP++;
					} else if(lineSplit2[3].equals("어린이")) {
						kidCountP++;
					} else if(lineSplit2[3].equals("청소년")) {
						teenCountP++;
					} else if(lineSplit2[3].equals("성인")) {
						adultCountP++;
					} else if(lineSplit2[3].equals("노인")) {
						oldCountP++;
					}
					
					priceSumP += Integer.parseInt(lineSplit2[5]);
				}
	
			}
			readLineCount++;
		}
		System.out.println("종합이용권 총 " + count1 + "매");
		System.out.println("1Day : " + dayCount + "매 , After4 : " + after4Count + "매");
		System.out.println("영유아 " + littleCount + " 유아 " + babyCount + " 어린이 " 
				+ kidCount + " 청소년 " + teenCount + " 성인 " + adultCount + " 노인 " + oldCount);
		System.out.println("종합이용권 총 매출 : " + priceSum + "원");
		System.out.println("");
		System.out.println("파크이용권 총 " + count1P + "매");
		System.out.println("1Day : " + dayCountP + "매 , After4 : " + after4CountP + "매");
		System.out.println("영유아 " + littleCountP + " 유아 " + babyCountP + " 어린이 " 
				+ kidCountP + " 청소년 " + teenCountP + " 성인 " + adultCountP + " 노인 " + oldCountP);
		System.out.println("파크이용권 총 매출 : " + priceSumP + "원");
		
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
		}
		return 0;
	}

	void companionPossible() {
		System.out.println("동반할인을 받을 수 있습니다.\n");
	}

}
