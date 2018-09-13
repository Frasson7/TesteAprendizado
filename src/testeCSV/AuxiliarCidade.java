package testeCSV;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AuxiliarCidade {
	ArrayList<Cidade> listaCidades = new ArrayList<Cidade>();
	Cidade cidades = new Cidade();
	Scanner sc = new Scanner(System.in);

	public void lerCSV() throws IOException {
		FileInputStream fis = new FileInputStream("ListaCidades.csv");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		String line = br.readLine();

		while (line != null) {
			String[] separar = line.split(",");
			String ibge_id = separar[0];
			String uf = separar[1];
			String name = separar[2];
			String capital = separar[3];
			String lon = separar[4];
			String lat = separar[5];
			String no_accents = separar[6];
			String alternative_name = separar[7];
			String microregion = separar[8];
			String mesoregion = separar[9];
			line = br.readLine();

			cidades = new Cidade(ibge_id, uf, name, capital, lon, lat, no_accents, alternative_name, microregion,
					mesoregion);
			listaCidades.add(cidades);

		}

		for (Cidade s : listaCidades) {
			System.out.println(s);
		}

		br.close();
	}

	public void filtarCidades(String s) {
		System.out.println(listaCidades.get(0));
		for (Cidade cidade : listaCidades) {
			if (s.equals(cidade.getIbge_id()) || s.equals(cidade.getName()) || s.equals(cidade.getUf())
					|| s.equals(cidade.getCapital()) || s.equals(cidade.getLon()) || s.equals(cidade.getLat())
					|| s.equals(cidade.getNo_accents()) || s.equals(cidade.getAlternative_names())
					|| s.equals(cidade.getMicroregion()) || s.equals(cidade.getMesoregion())) {
				System.out.println(cidade);

			}

		}

	}

	public void countTotal() {
		int valor = listaCidades.size() - 1;
		System.out.println("Possuem " + valor + " itens registrados");

	}

	public void countDistinct(String s) {

		if (s.equals("ID")) {
			int cont = 0;
			for (Cidade cidade : listaCidades) {
				String c = cidade.getIbge_id();
				for (Cidade cidade2 : listaCidades) {
					String c2 = cidade2.getIbge_id();
					if (c != c2) {
						cont++;
					}
				}
				break;
			}
			System.out.println(cont);

		}

		if (s.equals("UF")) {
			for (Cidade cidade : listaCidades) {
				int cont = 0;
				String c = cidade.getUf();
				for (int i = 1; i < listaCidades.size(); i++) {
					Cidade cidade2 = listaCidades.get(1);					
					String c2 = cidade2.getUf();
					if (c != c2) {
						cont++;
					}
				} {
				}
				System.out.println("Possuem " + cont + " UF diferentes");
				break;
			}

		}

	}

	public void comandos(String comando) {
		if (comando.equals("count *")) {
			countTotal();
		}

		if (comando.equals("count distinct")) {
			System.out.print(
					"Digite a coluna que deseja(Opções: ID, Nome, UF, Capital, Longitude, Latitude, Nomes Alternativos, Microregião e Mesoregião): ");
			String coluna = sc.nextLine();
			countDistinct(coluna);
		}
		if (comando.equals("filter")) {
			System.out.print("Digite o que deseja filtar: ");
			String valor = sc.nextLine();
			filtarCidades(valor);

		}

	}

}
