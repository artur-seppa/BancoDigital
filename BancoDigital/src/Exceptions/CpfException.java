package Exceptions;

public class CpfException extends Exception{
	public CpfException() {
		super("Insira um numero valido de CPF");
	}

	@Override
	public String toString() {
		return "Insira um numero valido de CPF";
	}	
}
