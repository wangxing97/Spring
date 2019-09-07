package com.wx.spring.factory;

import com.wx.spring.bean.AirPlane;

/*
 *  静态工厂
 */
public class AirPlaneStaticFactory {

	public static AirPlane getAirPlane(String JzName) {
		System.out.println("静态工厂正在为你造飞机...");
		AirPlane ap = new AirPlane();
		ap.setJzName(JzName);
		ap.setAirPlaneName("波音737");
		ap.setAirPlaneLength("300m");
		ap.setJyLength("198.98cm");
		return ap;
	}
	
}
