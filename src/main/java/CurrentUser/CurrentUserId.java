package CurrentUser;

public class CurrentUserId {
	static int id=-1;
	static String name="";
	public static void setId(int currentId) {
		id = currentId;
	}
	public static void setName(String currentName) {
		name = currentName;
	}
	public static int getId() {
		return id;
	}
	public static String getName() {
		return name;
	}
}
