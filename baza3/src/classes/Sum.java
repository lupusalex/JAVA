package classes;

import interfaces.BinaryOperator;

public class Sum implements BinaryOperator{

	@Override
	public double operate(double operand1, double operand2) {
		return operand1 + operand2;
	}
	
}
