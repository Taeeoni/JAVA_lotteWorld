package LotteTicket;

public class StaticValue {
	// 종합이용권 가격
	static final int ALL_1D_ADULT = 62000, ALL_1D_TEEN = 54000, ALL_1D_KID = 47000, ALL_1D_BABY = 15000;
	static final int ALL_A4_ADULT = 50000, ALL_A4_TEEN = 43000, ALL_A4_KID = 36000, ALL_A4_BABY = 15000;

	// 파크이용권 가격
	static final int PARK_1D_ADULT = 59000, PARK_1D_TEEN = 52000, PARK_1D_KID = 46000, PARK_1D_BABY = 15000;
	static final int PARK_A4_ADULT = 47000, PARK_A4_TEEN = 41000, PARK_A4_KID = 35000, PARK_A4_BABY = 15000;

	// 주민등록번호 분석
	static final int OLD_GENERATION = 19000000, NEW_GENERATION = 20000000;

	// 나이에 따른 범위
	static final int MIN_BABY = 1, MIN_KID = 3, MIN_TEEN = 12, MIN_ADULT = 18, MIN_OLD = 65;

	// 할인율
	static final double DISABLED = 0.5, NATIONAL_MERIT = 0.5, SOLDIER = 0.49, PREGNANT = 0.5, MANY_CHILDREN = 0.3;

	// 종합이용권 String 호출
	static final String ALL = "종합이용권";
	static final String PARK = "파크이용권";
	
	// 권종 String 호출 
	static final String FULLDAY = "1Day";
	static final String AFTER4 = "After4";
	
	// 나이그룹 String 호출
	static final String LITTLE = "영유아";
	static final String BABY = "유아";
	static final String KID = "어린이";
	static final String TEEN = "청소년";
	static final String ADULT = "성인";
	static final String OLD = "노인";
	
	// 우대사항 String 호출
	static final String NOTHING_STR = "없음";
	static final String DISABLED_STR = "장애인";
	static final String NATIONAL_STR = "국가유공자";
	static final String SOLDIER_STR = "휴가장병";
	static final String PREGNANT_STR = "임산부";
	static final String MANYCHIRDREN_STR = "다둥이";
	static final String COMPANION_STR = "동반할인";

}
