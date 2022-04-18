
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
