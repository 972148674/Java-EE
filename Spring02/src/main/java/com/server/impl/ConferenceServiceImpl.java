package com.server.impl;

import java.util.List;

import com.entity.Boss;
import com.entity.Car;
import com.entity.Conference;
import com.server.ConferenceService;

public class ConferenceServiceImpl implements ConferenceService{

	Conference conference;
	
	public ConferenceServiceImpl() {
		super();
	}

	public ConferenceServiceImpl(Conference conference) {
		super();
		this.conference = conference;
	}

	public Conference getConference() {
		return conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

	@Override
	public void conference() {

		System.out.println("会议主题：" + conference.getTheme());
		System.out.println();
		System.out.println();
		
		List<Boss> list = conference.getLists();
		
		for(int i=0; i<list.size(); i++) {
			Boss boss = list.get(i);
			System.out.println("老板姓名：" + boss.getName()
							+ "     爱好：" + boss.getHobby()
							+ "     公司：" + boss.getCompany()
					);
			Car car = boss.getCar();
			System.out.println("车的品牌：" + car.getBrand()
								+ "     颜色：" + car.getColour()
								+ "     排量：" + car.getDisplacement());
		}
	}

}
