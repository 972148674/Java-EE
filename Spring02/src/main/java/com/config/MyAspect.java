package com.config;

public class MyAspect {

	public void before() {
		System.out.println("拦截器--之前执行");
	}
	
	public void after() {
		System.out.println("拦截器--之后执行");
	}
	
}
