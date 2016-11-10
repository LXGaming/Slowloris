package io.github.lxgaming.slowloris.configuration;

public class Config {
	
	private String host;
	private int port;
	private int timeout;
	private int connections;
	private int sleep;
	private String payload;
	private String keepalive;
	
	public String getHost() {
		return this.host;
	}
	
	public int getPort() {
		return this.port;
	}
	
	public int getTimeout() {
		return this.timeout;
	}
	
	public int getConnections() {
		return this.connections;
	}
	
	public int getSleep() {
		return this.sleep;
	}
	
	public String getPayload() {
		return this.payload;
	}
	
	public String getKeepAlive() {
		return this.keepalive;
	}
}