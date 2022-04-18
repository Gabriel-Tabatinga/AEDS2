
public class Retangulo {
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
