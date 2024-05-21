package stack;

public class Calculator {
	private Stack<Integer> valueStack;
	
	public Calculator() {
		valueStack = new Stack<>();
	}
	
	public void calc_values(int v) {
		valueStack.push(v);
		System.out.println(valueStack.peek());
	}
	
	public void calc_operador (Calculator c, char op) {
		Integer v1, v2, v = 0;
		if (valueStack.isEmpty()) {
			v2 = 0;
		}
		else
			v2 = valueStack.pop();
		if (valueStack.isEmpty()) {
			v1 = 0;
		}
		else
			v1 = valueStack.pop();
		
	switch (op) {
	case '+': v = v1+v2; break;
	case '-': v = v1-v2; break;
	case '*': v = v1*v2; break;
	case '/': v = v1/v2; break;
	}
	
	valueStack.push(v); /* empilha resultado */
	System.out.println(valueStack.peek()); /* imprime topo da pilha */
	}


}
