
public class Application {

	public static void metodo(String entrada) throws NumberFormatException{
		int i;
		i= Integer.parseInt(entrada);
		System.out.println("i: "+ i);
	}
	
	public static void ehPar(int i) throws Exception{
		if((i%2)==0)
			System.out.println(i + " é par!");
		else
			throw new Exception("número informado é impar");
	}
	
	public static void main(String[] args) {
		/*System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		System.out.println(args[3]);
		System.out.println(args[4]);*/
		//int i;
		
		/*try {
			metodo(args[0]);
		} catch(NumberFormatException excecao) {
			System.out.println("Informe um numero, seu idiota");
		} catch(ArrayIndexOutOfBoundsException excecao) {
			System.out.println("Cade o argumento, seu idiota");
		} catch(Exception excecao) {
			System.out.println("Deu um erro ai, seu idiota, se vira :)");
		}*/
		
		try {
			ehPar(11);
		} catch(Exception excecao){
			System.out.println(excecao.getMessage());
		}
	}
}
