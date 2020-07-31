package com.flavio.inspecaodecabinas.excecao;

import com.flavio.inspecaodecabinas.excecao.InspecaoCabinasException;

/**
 * Criado por...//TODO documentar
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class FormatoInvalidoException extends InspecaoCabinasException {
	public FormatoInvalidoException() {
		super("O formato do campo não é valido.");
	}
}
