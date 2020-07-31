package com.flavio.inspecaodecabinas.excecao;

/**
 * //TODO Documentar
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class TamanhoInvalidoException extends InspecaoCabinasException {
	public TamanhoInvalidoException() {
		super("Tamanho do campo inválido.");
	}
}
