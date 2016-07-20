package com.test.simul.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.test.simul.vo.CollectdVo;
import com.test.simul.vo.CollectdWinVo;
import com.test.simul.vo.MetricVo;

public class JsonToVo {

	CollectdVo collectdVo;
	CollectdWinVo collectdWinVo;
	MetricVo metricVo;
	Gson gson;
	
	public JsonToVo()	{
		//gson = new GsonBuilder().serializeNulls().create();
		gson = new Gson();
	}
	
	/*//collectd
	public List<CollectdVo> sampleToCollectdVo(List<String> list)	{
		List<CollectdVo> collectdList = new ArrayList<CollectdVo>();
		
		for(int i=0; i < list.size(); i++)	{
			Object obj[] = new Object[1];
			obj = gson.fromJson(list.get(i), Object[].class);

			Map<String, String> map = (Map) obj[0];
			if(map.get("plugin_instance").isEmpty())	{
				map.put("plugin_instance", null);
			} 
			
			collectdVo = gson.fromJson(map.toString(), CollectdVo.class);
			collectdList.add(collectdVo);
		}
		
		return collectdList;
	}
	
	//collectdwin
	public List<CollectdWinVo> sampleToCollectdWinVo(List<String> list)	{
		List<CollectdWinVo> collectdWinList = new ArrayList<CollectdWinVo>();
		
		for(int i=0; i < list.size(); i++)	{
			Object obj[] = new Object[1];
			obj = gson.fromJson(list.get(i), Object[].class);
			
			Map<String, String> map = (Map) obj[0];
			if(map.get("plugin_instance").isEmpty())	{
				map.put("plugin_instance", null);
			}
			
			collectdWinVo = gson.fromJson(map.toString(), CollectdWinVo.class);
			collectdWinList.add(collectdWinVo);
		}
		
		return collectdWinList;
	}*/
	
	public List<MetricVo> sampleToMetricVo(List<String> list)	{
		List<MetricVo> metricList = new ArrayList<MetricVo>();
		
		for(int i=0; i < list.size(); i++)	{
			Object obj[] = new Object[1];
			obj = gson.fromJson(list.get(i), Object[].class);

			Map<String, String> map = (Map) obj[0];
			if(map.get("plugin_instance").isEmpty())	{
				map.put("plugin_instance", null);
			} 
			
			metricVo = gson.fromJson(map.toString(), MetricVo.class);
			metricList.add(metricVo);
		}
		
		return metricList;
	}
	
	public void voToJson()	{
		
	}
}
