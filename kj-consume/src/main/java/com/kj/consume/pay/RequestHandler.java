package com.kj.consume.pay;

import com.kj.common.utils.MD5Util;
import java.util.*;

public class RequestHandler {

	/** 网关url地址 */
	private String gateUrl;

	/** 密钥 */
	private String key;

	/** 请求的参数 */
	private SortedMap parameters;

	/** debug信息 */
	private String debugInfo;


	public RequestHandler() {
		this.parameters = new TreeMap();
	}

	/**
	 * 获取入口地址,不包含参数值
	 */
	public String getGateUrl() {
		return gateUrl;
	}

	/**
	 * 设置入口地址,不包含参数值
	 */
	public void setGateUrl(String gateUrl) {
		this.gateUrl = gateUrl;
	}

	/**
	 * 获取密钥
	 */
	public String getKey() {
		return key;
	}

	/**
	 * 设置密钥
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 获取参数值
	 * 
	 * @param parameter
	 *            参数名称
	 * @return String
	 */
	public String getParameter(String parameter) {
		String s = (String) this.parameters.get(parameter);
		return (null == s) ? "" : s;
	}

	/**
	 * 设置参数值
	 * 
	 * @param parameter
	 *            参数名称
	 * @param parameterValue
	 *            参数值
	 */
	public void setParameter(String parameter, String parameterValue) {
		String v = "";
		if (null != parameterValue) {
			v = parameterValue.trim();
		}
		this.parameters.put(parameter, v);
	}

	/**
	 * 返回所有的参数
	 * 
	 * @return SortedMap
	 */
	public SortedMap getAllParameters() {
		return this.parameters;
	}

	/**
	 * 获取debug信息
	 */
	public String getDebugInfo() {
		return debugInfo;
	}


	/**
	 * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
	 */
	protected void createSign() {
		StringBuffer sb = new StringBuffer();
		Set es = this.parameters.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + this.getKey());

		String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();

		this.setParameter("sign", sign);

		// debug信息
		this.setDebugInfo(sb.toString() + " => sign:" + sign);

	}

	/**
	 * 设置debug信息
	 */
	protected void setDebugInfo(String debugInfo) {
		this.debugInfo = debugInfo;
	}


}
