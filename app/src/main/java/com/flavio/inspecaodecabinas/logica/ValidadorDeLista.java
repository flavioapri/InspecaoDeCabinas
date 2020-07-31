package com.flavio.inspecaodecabinas.logica;

import com.flavio.inspecaodecabinas.excecao.CaracterInvalidoException;
import com.flavio.inspecaodecabinas.excecao.FormatoInvalidoException;
import com.flavio.inspecaodecabinas.excecao.InformacoesInsuficientesException;
import com.flavio.inspecaodecabinas.excecao.InspecaoCabinasException;
import com.flavio.inspecaodecabinas.excecao.StringVaziaException;
import com.flavio.inspecaodecabinas.excecao.TamanhoInvalidoException;

/**
 * Separa os campos da String com as informações da cabina e verifica se estas são validas.
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
//TODO extrair valor das constantes para outra classe
public class ValidadorDeLista {
	/* Expressão regular para identificar se a string não possui apenas números */
	private static final String NAO_CONTEM_APENAS_NUMERO = "(?!^\\d+$)^.+$";
	/* Expressão regular do formato do campo NP*/
	private static final String FORMATO_CAMPO_NP = "\\d{2}\\.\\d{6}\\/\\d";
	/* Expressão regular do formato do campo FZ*/
	private static final String FORMATO_CAMPO_FZ = "\\d{6}";
	/* Todas as colunas na string são separadas por um espaço em branco*/
	private static final String ESPACO = " ";
	private static final int QTD_MINIMA_INFORMACOES = 4;
	/* Caractere contido no inicio de todos os codes.*/
	private static final String CARACTER_INICIAL_CODE = "I";
	private static final int ARRAY_VAZIO = 0;
	private static final int POSICAO_SEQUENCIA = 0;
	private static final int POSICAO_NP = 1;
	private static final int POSICAO_FZ = 2;
	private static final int POSICAO_PAIS = 3;
	private static final int POSICAO_SERIE = 5;
	private static final int TAMANHO_MAXIMO_SEQUENCIA = 6;
	private static final int TAMANHO_MINIMO_SEQUENCIA = 5;
	private static final int TAMANHO_NP = 11;
	private static final int TAMANHO_FZ = 6;

	/**
	 * Divide a string com as informações utilizando ESPACO, salva em um array e faz verificação se a string é vazia e se existe
	 * a quantidade minima de informações para se constituir uma cabina, após envia para o primeiro método da cadeia de
	 * verificações.
	 *
	 * @param informacoes string com as informações da cabina
	 * @return envia o array gerado com cada informação contida em uma posição para validar o campo sequencia.
	 */
	public static String[] validar(String informacoes) {
		String[] informacoesSeparadas = informacoes.split(ESPACO);
		try {
			if (informacoesSeparadas.length == ARRAY_VAZIO)
				throw new StringVaziaException();
			if (informacoesSeparadas.length < QTD_MINIMA_INFORMACOES)
				throw new InformacoesInsuficientesException();
		} catch (InspecaoCabinasException ie) {
			System.err.println(ie.getMessage());
			return null;
		}
		return validarSequencia(informacoesSeparadas);
	}

	/**
	 * Valida o campo "sequencia". Deve possuir tamanho máximo de 6 e mínimo de 5 e não pode conter caracteres diferentes de
	 * números.
	 *
	 * @param informacoesSeparadas array com cada informação contida em uma posição
	 * @return chama o método para verificar o NP enviando o array com as informações
	 */
	private static String[] validarSequencia(String[] informacoesSeparadas) {
		try {
			if ((informacoesSeparadas[POSICAO_SEQUENCIA]
					.length() > TAMANHO_MAXIMO_SEQUENCIA) || (informacoesSeparadas[POSICAO_SEQUENCIA]
					.length() < TAMANHO_MINIMO_SEQUENCIA))
				throw new TamanhoInvalidoException();
			if (informacoesSeparadas[POSICAO_SEQUENCIA].matches(NAO_CONTEM_APENAS_NUMERO))
				throw new CaracterInvalidoException();
		} catch (InspecaoCabinasException ie) {
			System.err.println(ie.getMessage());
			return null;
		}
		return validarNP(informacoesSeparadas);
	}

	/**
	 * Valida o campo "np" verificando se o formato do campo esta correto através de expressão regular. O formato deve ser dd.dddddd/d.
	 *
	 * @param informacoesSeparadas array com cada informação contida em uma posição
	 * @return chama o método verificador de FZ enviando o array com as informações
	 */
	private static String[] validarNP(String[] informacoesSeparadas) {
		try {
			if (!(informacoesSeparadas[POSICAO_NP].matches(FORMATO_CAMPO_NP)))
				throw new FormatoInvalidoException();
		} catch (InspecaoCabinasException ie) {
			System.err.println(ie.getMessage());
			return null;
		}
		return validarFZ(informacoesSeparadas);
	}

	/**
	 * Valida o campo "fz" verificando se o formato do campo esta correto através de expressão regular. O formato deve ser dddddd.
	 *
	 * @param informacoesSeparadas array com cada informação contida em uma posição
	 * @return chama o método verificador do campo pais enviando o array com as informações
	 */
	private static String[] validarFZ(String[] informacoesSeparadas) {
		try {
			if (!(informacoesSeparadas[POSICAO_FZ].matches(FORMATO_CAMPO_FZ)))
				throw new FormatoInvalidoException();
		} catch (InspecaoCabinasException ie) {
			System.err.println(ie.getMessage());
			return null;
		}
		return informacoesSeparadas;
	}
}
