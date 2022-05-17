package Exceptions;

import java.util.Arrays;

public class NumberException extends Exception{
		
		public NumberException() {
			super("Você deve obter mais de 18 anos");
		}

		@Override
		public String toString() {
			return "Você deve obter mais de 18 anos";
		}		
		
		
}
