
public class Applicacao {

	public static void mudar(Cliente c) {
		c.setNome("Joana");
		c.setCodigo(26210);
	}

	public static void main(String[] args) {

		Cliente c1, c2, c3;
		c1 = new Cliente();
		c2 = new Cliente("Fernanda", 28510);
		c3 = c1;

		c3.setNome("Carla");
		c3.setCodigo(6740);

		System.out.println("Conteudo das variaveis: ");
		System.out.println("c1: " + c1);
		System.out.println("c2: " + c2);
		System.out.println("c3: " + c3);

		System.out.println("\nCliente c1");
		System.out.println("Nome: " + c1.getNome());
		System.out.println("Codigo: " + c1.getCodigo());

		System.out.println("\nCliente c2");
		System.out.println("Nome: " + c2.getNome());
		System.out.println("Codigo: " + c2.getCodigo());

		System.out.println("\nCliente c3");
		System.out.println("Nome: " + c3.getNome());
		System.out.println("Codigo: " + c3.getCodigo());

		mudar(c2);
		
		System.out.println("\nCliente c2 depois mudanca");
		System.out.println("Nome: " + c2.getNome());
		System.out.println("Codigo: " + c2.getCodigo());
	}

}
