package tp.exception;

public class MemberNotFoundException extends Exception{
	
	private String failId; //찾지 못한 회원 ID
	public MemberNotFoundException(){}
	public MemberNotFoundException(String message){
		super(message);
	}
	public MemberNotFoundException(String message, String failId) {
		super(message);
		this.failId = failId;
	}
	public String getFailId() {
		return failId;
	}
	
}
