
public class Caracter {
	private char valor;
	public Caracter() {
		valor = 0;
	}
	public Caracter(char i) {
		valor = i;
	} 
	public int getValor() {
		return valor;
	}
	public void setValor(char valor) {
		this.valor = valor;
	}
	public void imprimir() {
		System.out.println(this.valor);
	}
}
