package app.saikat.PojoCollections.SocketMessages.Authentication;

public class ResponseSocket {

	private int port;
	private String token;

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public ResponseSocket port(int port) {
		this.port = port;
		return this;
	}

	public ResponseSocket token(String token) {
		this.token = token;
		return this;
	}

}