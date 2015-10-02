package com.demo.devops;

public class UserVO {
	private String name;
	private String address;
	private String state;
	private String country;
	public UserVO() {
		
	}
	public UserVO(String name, String address, String state, String country) {
		super();
		this.name = name;
		this.address = address;
		this.state = state;
		this.country = country;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return new StringBuilder().append(" name: ").append(name).append("\n")
				.append(" address: ").append(address).append("\n")
				.append(" state: ").append(state).append("\n")
				.append(" country:").append(country).toString();
				
	}
	
	

}
