package ru.job4j.calculator;

public class Calculator {

	double result;

	public void add (double first, double second) {
		this.result = first + second;
	}

	public void substruct (double first, double second) {
		this.result = first - second;
	}

	public void div (double first, double second) {
		if (second != 0) {
		this.result = first / second;
		} else {
		  this.result = 0;
		  }
	}

	public void multiple (double first, double second) {
		this.result = first * second;
	}
	
	public double getResult () {
		return this.result;
	}
}