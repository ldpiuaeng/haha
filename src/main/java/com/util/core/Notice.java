package com.util.core;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Created by huhaitian on 2017/8/22.
 */

public class Notice implements Serializable {

	private String applicationName;		// 应用名
	private String applicationCode;		// 应用编码，IT资产系统
	private String noticeMail;			// 告警邮箱
	private String noticeTel;			// 告警电话
	private String level;				// 告警级别(行内告警平台)
	private String execMethodName;		// 执行方法
	private String execTime;			// 执行耗费时间（毫秒）
	private String traceId;				// 日志中traceId
	private String spanId;				// 日志中spanId

	public static String generateMessage(String applicationName, String applicationCode, String noticeMail, String noticeTel, String level,
			String execMethodName, String execTime, String traceId, String spanId) {
		Notice notice = new Notice(applicationName, applicationCode, noticeMail, noticeTel, level, execMethodName, execTime, traceId, spanId);
		return JSON.toJSONString(notice);
	}

	public Notice() {
	}

	public Notice(String applicationName, String applicationCode, String noticeMail, String noticeTel, String level, String execMethodName,
			String execTime, String traceId, String spanId) {
		this.applicationName = applicationName;
		this.applicationCode = applicationCode;
		this.noticeMail = noticeMail;
		this.noticeTel = noticeTel;
		this.level = level;
		this.execMethodName = execMethodName;
		this.execTime = execTime;
		this.traceId = traceId;
		this.spanId = spanId;
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

	public String getNoticeMail() {
		return noticeMail;
	}

	public void setNoticeMail(String noticeMail) {
		this.noticeMail = noticeMail;
	}

	public String getNoticeTel() {
		return noticeTel;
	}

	public void setNoticeTel(String noticeTel) {
		this.noticeTel = noticeTel;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
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

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getSpanId() {
		return spanId;
	}

	public void setSpanId(String spanId) {
		this.spanId = spanId;
	}
}
