package com.flavio.inspecaodecabinas.logica;

/**
 * Classe contendo as constantes da aplicação.
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
//TODO explicar as expressões regulares em cada comentário
public class Constantes {
	/* Expressão regular do formato do campo sequencia*/
	public static final String FORMATO_CAMPO_SEQUENCIA = "\\d{5,6}";
	/* Expressão regular do formato do campo NP*/
	public static final String FORMATO_CAMPO_NP = "\\d{2}\\.\\d{6}\\/\\d";
	/* Expressão regular do formato do campo FZ*/
	public static final String FORMATO_CAMPO_FZ = "\\d{6}";
	/* Expressão regular do formato do campo PAIS*/
	public static final String FORMATO_CAMPO_PAIS = "\\w{3}";
	/* Expressão regular do formato do campo SERIE*/
	public static final String FORMATO_CAMPO_SERIE = "\\d{4}";
	/* Expressão regular do formato do campo CODE*/
	public static final String FORMATO_CAMPO_CODE = "[A-Z]{2}\\w{3}";
	/* Todas as colunas na string são separadas por um espaço em branco*/
	public static final String ESPACO = " ";
	public static final int QTD_MINIMA_INFORMACOES = 4;
	/* Caractere contido no inicio de todos os codes.*/
	public static final String CARACTER_INICIAL_CODE = "I";
	public static final int POSICAO_SEQUENCIA = 0;
	public static final int POSICAO_NP = 1;
	public static final int POSICAO_FZ = 2;
	public static final int POSICAO_PAIS = 3;
	public static final int POSICAO_SERIE = 5;
}
