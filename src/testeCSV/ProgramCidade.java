package testeCSV;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ProgramCidade {

	public static void main(String[] args) throws IOException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Locale.setDefault(Locale.US);
		AuxiliarCidade cidade = new AuxiliarCidade();		
		cidade.lerCSV();
		
		System.out.println("Digite algum comando");
		System.out.println("'count *' escreve o total de itens registrados.");
		System.out.println("'count distinct' escreve o total de valores diferentes da coluna desejada. ");
		System.out.print("'filter' escreve todas as linhas que possuem, inserindo o valor desejado:  ");
		String comando = sc.nextLine();
		cidade.comandos(comando);
		
		
		sc.close();

	}

}
