
public class Application {

	public static void main(String[] args) {
		String input;	
		input = MyIO.readLine();
		Pilha pilha = new Pilha();
		Caracter caracter = new Caracter();
		while(!input.equals("FIM")) {
			for(int i=0;i<input.length();i++) {
				if(input.charAt(i)=='(' || input.charAt(i)==')' || input.charAt(i)=='[' || input.charAt(i)==']') {
					caracter.setValor(input.charAt(i));
					pilha.empilhar(caracter);
				}
			}
			verificaFormato(pilha);
			input = MyIO.readLine();
		}
	}
	
	public static void verificaFormato(Pilha pilha){
		
		if(pilha.desempilhar() == )
			System.out.println("correto");
		else
			System.out.println("incorreto");
	}

}
