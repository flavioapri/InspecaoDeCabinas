package com.flavio.inspecaodecabinas.excecao;

/**
 * A informação não atende o formato especificado.
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class FormatoInvalidoException extends InspecaoCabinasException {
	public FormatoInvalidoException() {
		super("O formato do campo não é valido.");
	}
}
