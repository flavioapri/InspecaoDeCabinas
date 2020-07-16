package com.flavio.inspecaodecabinas.helper;

import com.flavio.inspecaodecabinas.modelo.Baumuster;
import com.flavio.inspecaodecabinas.modelo.Cabina;
import com.flavio.inspecaodecabinas.modelo.Code;
import com.flavio.inspecaodecabinas.modelo.Pais;
import com.flavio.inspecaodecabinas.modelo.Serie;

import java.util.ArrayList;
import java.util.List;

/**
 * Cria objetos do tipo Cabina através de string extraída do arquivo de texto da lista do PRM.
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class CabinaHelper {
	/* Todas as colunas na string são separadas por um espaço em branco*/
	private static final String ESPACO = " ";
	/* Caractere contido no inicio de todos os codes.*/
	private static final String CARACTER_INICIAL_CODE = "I";
	private static final int POSICAO_SEQUENCIA = 0;
	private static final int POSICAO_NP = 1;
	private static final int POSICAO_FZ = 2;
	private static final int POSICAO_PAIS = 3;
	private static final int POSICAO_INICIAL_BAUMUSTER = 4;
	private static final int POSICAO_FINAL_BAUMUSTER = 5;
	private static final int POSICAO_SERIE = 7;

	/**
	 * Inicializa cada atributo através de strings extraídas de um array gerado a partir da string com as informações da cabina.
	 * A posição de cada atributo no array e fixa e determinada pelas constantes <b>POSICAO</b> da classe.
	 *
	 * @param linha string do arquivo de lista do PRM com os dados da cabina.
	 * @return objeto Cabina.
	 */
	public Cabina gerarCabina(String linha) {
		Cabina cabina = new Cabina();
		Pais pais = new Pais();
		Baumuster baumuster = new Baumuster();
		Serie serie = new Serie();
		List<Code> codes = new ArrayList<>();

		String[] linhaDividida = linha.split(ESPACO);

		cabina.setSequencia(linhaDividida[POSICAO_SEQUENCIA]);
		cabina.setNp(linhaDividida[POSICAO_NP]);
		cabina.setFz(linhaDividida[POSICAO_FZ]);
		pais.setCodigo(linhaDividida[POSICAO_PAIS]);
		cabina.setPais(pais);
		cabina.setCodes(codes);
		/* O Baumuster e composto por duas posições no array, uma contendo a letra "D" e a outra o número e é também concatenado
		 um espaço entre as duas posições para estar de acordo com o padrão PRM [letra][espaço][número]"*/
		String stringBaumuster =
				linhaDividida[POSICAO_INICIAL_BAUMUSTER].concat(ESPACO)
														.concat(linhaDividida[POSICAO_FINAL_BAUMUSTER]);
		baumuster.setCodigo(stringBaumuster);
		cabina.setBaumuster(baumuster);
		serie.setNumero(linhaDividida[POSICAO_SERIE]);
		cabina.setSerie(serie);

		/* Busca os codes a partir da ultima referência conseguida que no cado é POSICAO_SERIE */
		for (int contador = POSICAO_SERIE; contador < linhaDividida.length; contador++) {
			if (linhaDividida[contador].startsWith(CARACTER_INICIAL_CODE)) {
				Code code = new Code();
				code.setCodigo(linhaDividida[contador]);
				codes.add(code);
			}
		}
		return cabina;
	}
}
