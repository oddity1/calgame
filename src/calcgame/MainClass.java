package calcgame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import clac.Calc;
import dto.MunjeDto;

public class MainClass {

	public static void main(String[] args) {

		// 연산 게임
		System.out.println("연산 게임 시작");
		Calc cc = new Calc();

		// 문제 수 사용자 지정
		cc.inputN();

		// 사용자 지정 수만큼 문제 생성
		ArrayList<MunjeDto> mList = cc.makeMunje();

		// 문제 출력하고 정답입력 정답비교
		for (MunjeDto dto : mList) {

			System.out.println(dto.toString());
			cc.checkDab(cc.userDab(), dto.getDab());
			
		// 종료 기능 추가 필요
			
		}
	}
}

