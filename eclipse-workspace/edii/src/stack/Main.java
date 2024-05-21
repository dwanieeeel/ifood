package stack;

public class Main {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();

    
        calculator.calc_values(1);
        calculator.calc_values(2); 
        calculator.calc_operador(calculator, '-');
        calculator.calc_values(4);
        calculator.calc_values(5);
        calculator.calc_operador(calculator, '+');
        calculator.calc_operador(calculator, '*');
        

	}

}
