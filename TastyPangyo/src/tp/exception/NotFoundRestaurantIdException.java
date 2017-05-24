package tp.exception;

public class NotFoundRestaurantIdException extends Exception {
	public NotFoundRestaurantIdException(){}
	public NotFoundRestaurantIdException(String message){
		super(message);
	}
}
