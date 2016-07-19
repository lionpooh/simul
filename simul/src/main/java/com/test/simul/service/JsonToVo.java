package com.test.simul.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.test.simul.vo.CollectdVo;
import com.test.simul.vo.CollectdWinVo;

public class JsonToVo {

	CollectdVo collectdVo;
	CollectdWinVo collectdWinVo;
	Gson gson;
	
	public JsonToVo()	{
		//gson = new GsonBuilder().serializeNulls().create();
		gson = new Gson();
	}
	
	//collectd
	public List<CollectdVo> sampleToCollectdVo(List<String> list)	{
		List<CollectdVo> collectdList = new ArrayList<CollectdVo>();
		
		for(int i=0; i < list.size(); i++)	{
			Object obj[] = new Object[1];
			obj = gson.fromJson(list.get(i), Object[].class);
			
			//plugin_instance 값이 중간에 비어 있는 경우(plugin_instance = "")
			//이부분 처리 개선
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
	}
	
	public void voToJson()	{
		
	}
}
