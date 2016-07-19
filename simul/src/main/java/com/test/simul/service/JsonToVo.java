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
		gson = new Gson();
	}
	
	//collectd
	public List<CollectdVo> sampleToCollectdVo(List<String> list)	{
		List<CollectdVo> collectdList = new ArrayList<CollectdVo>();
		
		for(int i=0; i < list.size(); i++)	{
			Object obj[] = new Object[1];
			obj = gson.fromJson(list.get(i), Object[].class);
			
			//plugin_instance 값이 중간에 비어 있는 경우(plugin_instance = "")
			Map map = (Map) obj[0];
			if(map.get("plugin_instance") != null)	{
				
			} else {
				map.put("plugin_instance", null);
			}
		}
		
		return collectdList;
	}
	
	//collectdwin
	public List<CollectdWinVo> sampleToCollectdWinVo(List<String> list)	{
		List<CollectdWinVo> collectdWinList = new ArrayList<CollectdWinVo>();
		
		for(int i=0; i < list.size(); i++)	{
			
		}
		
		return collectdWinList;
	}
	
	public void voToJson()	{
		
	}
}
