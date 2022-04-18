
public class Aplicacao {

	public static int contarMaisculas(String entrada) {
		int cont = 0;
		for (int i = 0; i < entrada.length(); i++) {
			if ((entrada.charAt(i) >= 'A') && (entrada.charAt(i) <= 'Z')) {
				cont++;
			}
		}
		return cont;
	}

	public static void main(String[] args) {
		String entrada;
		int cont;
		entrada = MyIO.readLine();
		
		while(!entrada.equals("FIM")) {
			cont = contarMaisculas(entrada);
			System.out.println(cont);
			entrada = MyIO.readLine();
		}
		
	}

}
