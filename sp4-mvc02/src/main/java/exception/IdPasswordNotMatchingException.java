package exception;

public class IdPasswordNotMatchingException 
						extends RuntimeException {
	public IdPasswordNotMatchingException(
			 String message) {
		 super(message); // 호출
		
	 }
}
