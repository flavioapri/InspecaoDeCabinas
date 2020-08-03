package com.flavio.inspecaodecabinas.constantes;

/**
 * Expressões regulares e informações sobre o formato de cada informação da cabina onde:
 * <ul>
 *     <li><b>d</b> - Dígitos.</li>
 *     <li><b>w</b> - Alpha numéricos (letras ou dígitos)</li>
 *     <li><b>{d}</b> - Grupo de caracteres. O dígito representa a quantidade.</li>
 *     <li><b>[A-Z]</b> - Qualquer caracter em caixa alta de A a Z.</li>
 * </ul>
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class Formatos {

	public static final String SEQUENCIA = "\\d{5,6}";
	public static final String NP = "\\d{2}\\.\\d{6}\\/\\d";
	public static final String FZ = "\\d{6}";
	public static final String PAIS = "\\w{3}";
	public static final String SERIE = "\\d{4}";
	public static final String CODE = "[A-Z]{2}\\w{3}";
	/* Todas as colunas na string são separadas por um espaço em branco*/
	public static final String ESPACO = " ";
	/* Quantidade mínima de informações que a cabina deve possuir*/
	public static final int QTD_MINIMA_INFORMACOES = 4;
	/* Caractere contido no inicio de todos os codes.*/
	public static final String CARACTER_INICIAL_CODE = "I";
}
