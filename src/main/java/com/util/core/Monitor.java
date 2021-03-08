package com.util.core;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Created by huhaitian on 2017/8/17.
 */
public class Monitor implements Serializable {

	private static final long serialVersionUID = 1L;

	private String type = "monitor"; 	// 被收集的类型
	private String applicationName;		// 应用名
	private String applicationCode;		// 应用编码，IT资产系统
	private String execMethodName;		// 执行方法
	private String execTime;			// 执行耗费时间（毫秒）
	private String loginUserId;			// 登陆人
	private String inputParam;			// 输入参数（json格式，不必输）
	private String outParam;			// 输入参数（json格式，不必输）
	private String comment;				// 其他内容(如果是复杂格式请用json，不必输)

	/**
	 * 生成日志消息体
	 */
	public static String generateMessage(String applicationName, String applicationCode, String execMethodName, String execTime, String loginUserId,
			String inputParam, String outParam, String comment) {
		Monitor monitor = new Monitor(applicationName, applicationCode, execMethodName, execTime, loginUserId, inputParam, outParam, comment);
		return JSON.toJSONString(monitor);
	}

	public Monitor() {
	}

	public Monitor(String applicationName, String applicationCode, String execMethodName, String execTime, String loginUserId, String inputParam,
			String outParam, String comment) {
		this.applicationName = applicationName;
		this.applicationCode = applicationCode;
		this.execMethodName = execMethodName;
		this.execTime = execTime;
		this.loginUserId = loginUserId;
		this.inputParam = inputParam;
		this.outParam = outParam;
		this.comment = comment;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getApplicationCode() {
		return applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	public String getExecMethodName() {
		return execMethodName;
	}

	public void setExecMethodName(String execMethodName) {
		this.execMethodName = execMethodName;
	}

	public String getExecTime() {
		return execTime;
	}

	public void setExecTime(String execTime) {
		this.execTime = execTime;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getInputParam() {
		return inputParam;
	}

	public void setInputParam(String inputParam) {
		this.inputParam = inputParam;
	}

	public String getOutParam() {
		return outParam;
	}

	public void setOutParam(String outParam) {
		this.outParam = outParam;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	/**
	 * 示例
	 */
	public static void main(String[] args) {
		String message = Monitor.generateMessage("OA", "A14", "com.pactera.web.helloworld", "1002", "huhaitian", null, null, null);
		/**
		 * TODO log.info(message);
		 */
		System.out.println(message);
	}
}
