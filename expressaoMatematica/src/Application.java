
public class Application {

	public static void main(String[] args) throws Exception{
		String input;	
		input = MyIO.readLine();
		Pilha pilha = new Pilha();
		Pilha saida = new Pilha();
		Boolean existeOutroPrioridade = false;
		while(!input.equals("FIM")) {
			for(int i=0;i<input.length();i++) {
				
				if(input.charAt(i)=='(' ) {
					pilha.empilhar(input.charAt(i));
				}
				
				else if(input.charAt(i)=='+' || input.charAt(i)=='-') {
					pilha.empilhar(input.charAt(i));
					for(int j=i+1;j<input.length();j++) {
						if(input.charAt(j)=='*' || input.charAt(j)=='/' || input.charAt(j)=='+' || input.charAt(j)=='-') {
							existeOutroPrioridade = true;
						}
					}
					
					if(existeOutroPrioridade == false) {
						saida.empilhar(pilha.desempilhar());
					}
					existeOutroPrioridade = false;
				}
				else if(input.charAt(i)=='*' || input.charAt(i)=='/') {
					
					pilha.empilhar(input.charAt(i));
					for(int j=i+1;j<input.length();j++) {
						if(input.charAt(j)=='*' || input.charAt(j)=='/') {
							existeOutroPrioridade = true;
						}
					}
					
					if(existeOutroPrioridade == false) {
						saida.empilhar(pilha.desempilhar());
					}
					existeOutroPrioridade = false;
					
				}
				else if(input.charAt(i)==')') {
					char carac = pilha.desempilhar();
					while(carac != '('){
						saida.empilhar(carac);
						carac = pilha.desempilhar();
					}
				}
				else if(input.charAt(i) !=' '){
					saida.empilhar(input.charAt(i));
				}
			}
			while(!pilha.pilhaVazia()){
				saida.empilhar(pilha.desempilhar());
			}
			
			
			char[] list = new char[90];
			int o=0;

			while(!saida.pilhaVazia()){
				list[o] = saida.desempilhar();
				o++;
			}
			o--;
			for(int k=o;k>=0;k--) {
				System.out.print(list[k]);
				System.out.print(" ");
			}
			input = MyIO.readLine();
			System.out.print("\n");
		}
		
		
		
	}
	

}
