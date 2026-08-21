package org.ovirt.engine.sdk4;

public class ProxyInfo {
	protected String host;
	private Integer proxyPort;
	protected String user;
	protected String password;
	private String proxyDomain;
	private String proxyWorkstation;

	private ProxyType proxyType;


	public ProxyInfo(String host, Integer proxyPort, String user, String password, String proxyDomain, ProxyType proxyType) {
		this.host = host;
		this.proxyPort = proxyPort;
		this.user = user;
		this.password = password;
		this.proxyDomain = proxyDomain;
		this.proxyType = proxyType;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(Integer proxyPort) {
		this.proxyPort = proxyPort;
	}

	public String getProxyDomain() {
		return proxyDomain;
	}

	public void setProxyDomain(String proxyDomain) {
		this.proxyDomain = proxyDomain;
	}

	public ProxyType getProxyType() {
		return proxyType;
	}

	public void setProxyType(ProxyType proxyType) {
		this.proxyType = proxyType;
	}

	public String getProxyWorkstation() {
		return proxyWorkstation;
	}

	public void setProxyWorkstation(String proxyWorkstation) {
		this.proxyWorkstation = proxyWorkstation;
	}


	//create an enum for proxy type
	public enum ProxyType {
		HTTP, SOCKS
	}
}
