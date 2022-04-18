class Retangulo {
	private double base;
	private double altura;

	Retangulo() {
		this.base = 0.0;
		this.altura = 0.0;
	}

	Retangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public Retangulo clone() {
		Retangulo copia;
		copia = new Retangulo(this.base, this.altura);
		/*
		 * copia = new Retangulo(); copia.base = this.base; copia.altura = this.altura;
		 */
		return copia;
	}

	public void imprime() {
		System.out.println("Dados do retangulo\nBase: " + this.base + "\nAltura: " + this.altura);
	}

	public double getArea() {
		return (this.base * this.altura);
	}

	public double getPerimetro() {
		return (2 * this.base + 2 * this.altura);
	}
}

public class Application {

	public static void main(String[] args) {
		Retangulo ret1, ret2, ret3;

		ret1 = new Retangulo(5.0, 3.0);
		ret2 = new Retangulo();

		ret2.setBase(7.0);
		ret2.setAltura(2.0);

		ret3 = ret1.clone();

		System.out.println("Ret1 ");
		ret1.imprime();
		System.out.println("Ret2 ");
		ret2.imprime();
		System.out.println("Ret3 ");
		ret3.imprime();

		System.out.println("Area de ret1: " + ret1.getArea());
		System.out.println("Periemtro de ret3: " + ret3.getPerimetro());

	}

}
