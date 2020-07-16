package com.flavio.inspecaodecabinas.logica;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
	//TODO Fazer com que o caminho e o nome do arquivo venham de acordo com a posterior seleção em algum campo.
	public List<String> lerLista(String caminho, Context contexto) {
		/* Lista criada com capacidade inicial 300 por questões de performance. É mais custoso o array ter de ficar se
		   redimensionando. Este valor é a média aproximada de cabinas sequênciadas.*/
		List<String> lista = new ArrayList<>(300);
		try {
			InputStreamReader input = new InputStreamReader(contexto.getAssets().open(caminho));
			BufferedReader leitor = new BufferedReader(input);

			String linha;
			while ((linha = leitor.readLine()) != null) {
				lista.add(linha);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
