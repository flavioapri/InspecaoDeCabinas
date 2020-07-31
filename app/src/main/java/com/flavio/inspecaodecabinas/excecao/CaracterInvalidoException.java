package com.flavio.inspecaodecabinas.excecao;

/**
 * //TODO Documentar
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class CaracterInvalidoException extends InspecaoCabinasException {
	public CaracterInvalidoException() {
		super("Contém caracteres inválidos.");
	}
}
