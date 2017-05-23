package tp.exception;

public class LoginFailException extends Exception{ //checked exception
	// exception class 생성. 1. exception상속받기 2. 생성자 2개 생성.(no-arg, String message받는애-얘는 에러메세지 뿌려주려고)
	public LoginFailException(){}
	public LoginFailException(String message){
		super(message);
	}
	
}
