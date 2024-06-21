package com.example.mybatisdemo.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculationServiceTest {

	@Test
	void addメソッドを呼び出した時に引数の値を足した結果を返す() {
		CalculationService calculationService = new CalculationService();
		//actual は実際の値
		int actual = calculationService.add(1, 2);
		assertThat(actual).isEqualTo(3);
	}

	@Test
	void subtractメソッドを呼び出した時に引数の値のaからbを引いた結果を返す() {
		CalculationService calculationService = new CalculationService();
		//actual は実際の値
		int actual = calculationService.subtract(3, 2);
		assertThat(actual).isEqualTo(1);
	}

}

