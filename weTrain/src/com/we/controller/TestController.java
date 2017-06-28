package com.we.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.we.common.util.PostUtil;
import com.we.dao.TrainMapper;

@Controller
public class TestController {

	private ApplicationContext applicationContext;
	
	@Before
	public void setUp(){
		applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}
	
	@Test
	public void test(){
		TrainMapper trainMapper=(TrainMapper) applicationContext.getBean("trainMapper");
		Map<String, Object> parmap=new HashMap<String, Object>();
		Integer num = trainMapper.selectCount(parmap);
		System.out.println("人员数量为:"+num);
	}
	
	
	
	
	@RequestMapping("index")
	public String show(){
		return "index/index";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public String msg(){
		String url ="https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=2017-06-29&leftTicketDTO.from_station=BJP&leftTicketDTO.to_station=BMP&purpose_codes=ADULT";
		return PostUtil.doGetString(url);
	}
	
}
