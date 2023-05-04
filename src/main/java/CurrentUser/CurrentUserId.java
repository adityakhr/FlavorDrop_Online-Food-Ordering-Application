package CurrentUser;

public class CurrentUserId {
	static int id=-1;
	public static void setId(int currentId) {
		id = currentId;
	}
	public static int getId() {
		return id;
	}
}
