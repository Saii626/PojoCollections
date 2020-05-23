package app.saikat.PojoCollections.SocketMessages.Authentication;

public class RequestSocket {

	private String name;

	private String password;

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RequestSocket name(String name) {
		this.name = name;
		return this;
	}

	public RequestSocket password(String password) {
		this.password = password;
		return this;
	}
	
	
}