package com.wx.spring.bean;

public class AirPlane {
	private String AirPlaneName;
	private String JzName;
	private String AirPlaneLength;
	private String JyLength;
	public String getAirPlaneName() {
		return AirPlaneName;
	}
	public void setAirPlaneName(String airPlaneName) {
		AirPlaneName = airPlaneName;
	}
	public String getJzName() {
		return JzName;
	}
	public void setJzName(String jzName) {
		JzName = jzName;
	}
	public String getAirPlaneLength() {
		return AirPlaneLength;
	}
	public void setAirPlaneLength(String airPlaneLength) {
		AirPlaneLength = airPlaneLength;
	}
	public String getJyLength() {
		return JyLength;
	}
	public void setJyLength(String jyLength) {
		JyLength = jyLength;
	}
	@Override
	public String toString() {
		return "AirPlane [AirPlaneName=" + AirPlaneName + ", JzName=" + JzName + ", AirPlaneLength=" + AirPlaneLength
				+ ", JyLength=" + JyLength + "]";
	}
	
}
