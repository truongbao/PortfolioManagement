package utility;

public class MessengeUtils {

	public final int ERROR = 1;
	public final int SUCCESS = 2;
	public final int WARNING = 3;
	private int status;
	private String message;

	public MessengeUtils() {

	}

	public MessengeUtils(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public void new_sucess_message(String message) {
		this.message = message;
		this.status = SUCCESS;
	}

	public void new_error_message(String message) {
		this.message = message;
		this.status = ERROR;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
