package com.flavio.inspecaodecabinas.logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Realiza a leitura do arquivo de texto que deve conter a lista do PRM e grava em um array para
 * posterior processamento.
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class LeitorDeLista {
	/**
	 * Le o arquivo e grava cada linha em um array de strings.
	 *
	 * @return lista com cada linha como string
	 * @since 1.0
	 */
	public static List<String> lerLista() {
		List<String> lista = new ArrayList<>(300);
		try {
			//TODO Fazer com que o caminho e o nome do arquivo venham automáticamente de acordo com a posterior seleção em algum
			// campo
			File arquivo = new File("lista_prm_teste.txt");
			Scanner scanner = new Scanner(arquivo);
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				lista.add(linha);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Um erro ocorreu na leitura do arquivo.");
			e.printStackTrace();
		}
		return null;
	}
}
