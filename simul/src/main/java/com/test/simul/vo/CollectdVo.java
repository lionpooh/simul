package com.test.simul.vo;

public class CollectdVo {
	
	private String values[];
	private String dstypes[];
	private String dsnames[];
	private Double time;
	private Double interval;
	private String host;
	private String plugin;
	private Object plugin_instance;
	private String type;
	private String type_instance;
	private Object meta;
	
	public String[] getValues() {
		return values;
	}
	public void setValues(String[] values) {
		this.values = values;
	}
	public String[] getDstypes() {
		return dstypes;
	}
	public void setDstypes(String[] dstypes) {
		this.dstypes = dstypes;
	}
	public String[] getDsnames() {
		return dsnames;
	}
	public void setDsnames(String[] dsnames) {
		this.dsnames = dsnames;
	}
	public Double getTime() {
		return time;
	}
	public void setTime(Double time) {
		this.time = time;
	}
	public Double getInterval() {
		return interval;
	}
	public void setInterval(Double interval) {
		this.interval = interval;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPlugin() {
		return plugin;
	}
	public void setPlugin(String plugin) {
		this.plugin = plugin;
	}
	public Object getPlugin_instance() {
		return plugin_instance;
	}
	public void setPlugin_instance(Object plugin_instance) {
		this.plugin_instance = plugin_instance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType_instance() {
		return type_instance;
	}
	public void setType_instance(String type_instance) {
		this.type_instance = type_instance;
	}
	public Object getMeta() {
		return meta;
	}
	public void setMeta(Object meta) {
		this.meta = meta;
	}
}
