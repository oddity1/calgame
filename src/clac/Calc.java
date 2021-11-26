package clac;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import dto.MunjeDto;
import dto.NumDto;

public class Calc {

	// 사용자가 만들어낼 문제의 수
	private int n;

	// 문제를 사용자가 입력한 만큼 나오게 만들기
	public void inputN() {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 문제를 생성 할까요?");
		System.out.println("입력(숫자만): ");
		n = sc.nextInt();

	}

	// 랜덤으로 연산자를 만드는 기능
	public String getRandOper() {
		Random rnd = new Random();
		ArrayList<String> opList = new ArrayList<String>();
		opList.add("+");
		opList.add("-");
		opList.add("*");
		opList.add("/");
		return opList.get(rnd.nextInt(opList.size()));
	}

	// 숫자 순서 바꾸기
	public void mySwap(MunjeDto dto) {
		if ((dto.getOp().equals("-") || dto.getOp().equals("/")) && (dto.getNum1() < dto.getNum2())) {
			int tmp = dto.getNum1(); // 값을 임시로 저장
			dto.setNum1(dto.getNum2());
			dto.setNum2(tmp);
		}
	}

	// 문제 만들기
	public ArrayList<MunjeDto> makeMunje() {
		ArrayList<MunjeDto> mList = new ArrayList<MunjeDto>();
		Random rnd = new Random();

		for (int i = 0; i < n; i++) {
			MunjeDto dto = new MunjeDto(); // 이걸 for 안에 넣어두어야 문제 공간이 여러개 생성됨

			dto.setNum1(rnd.nextInt(100) + 1);
			dto.setOp(getRandOper());
			dto.setNum2(rnd.nextInt(100) + 1);

			mySwap(dto); // 앞뒤바꾸기

			if (dto.getOp().equals("+")) {
				dto.setDab(dto.getNum1() + dto.getNum2());
			} else if (dto.getOp().equals("-")) {
				dto.setDab(dto.getNum1() - dto.getNum2());
			} else if (dto.getOp().equals("*")) {
				dto.setDab(dto.getNum1() * dto.getNum2());
			} else if (dto.getOp().equals("/")) {
				dto.setDab(dto.getNum1() / dto.getNum2());
			}
			mList.add(dto);
		}
		return mList;
	}

	// 무작위로 문제 출력(두자리 수만 나오게)
	public void munje(NumDto dto) {
		Random rd = new Random();
//		int num1 = rd.nextInt(99) + 1;
//		int num2 = rd.nextInt(99) + 1;
		dto.setNum1(rd.nextInt(99) + 1);
		dto.setNum2(rd.nextInt(99) + 1);
		// 답까지 셋팅
		dto.setResult(dto.getNum1() + dto.getNum2());

	}

	// 사용자의 입력 메소드
	public int userDab() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	// 답 체크 메소드
	public void checkDab(int user, int com) {
		if (user == com) {
			System.out.println("정답");
		} else
			System.out.println("오답");
	}

	// 나가기 메소드
	public boolean isExit() {
		System.out.print("다른 연산을 하시겠습니까?\n네(1), 아니오(0):");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n == 1) {
			return true;
		}
		return false;
	}
}

//	// 결과 출력 메소드
//	public void printResult() {
//		
//		MunjeDto mDto = new MunjeDto();
//		
//		munje(nDto); // 문제를 만들고
//		System.out.print(nDto.getNum1() + " + " + nDto.getNum2() + " = ");
//////		System.out.println(nDto.getResult());   // 답(임시)
////		// 입력 받기
//		
//		// 답체크하기
//		if (checkDab(mDto.getUserdab(), mDto.getDab())) {
//			System.out.println("맞다");
//		} else {
//			System.out.println("틀렸다");
//		}
//	}
//}
