package com.test.simul.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.test.simul.vo.CollectdVo;
import com.test.simul.vo.CollectdWinVo;
import com.test.simul.vo.MetricValues;
import com.test.simul.vo.SimulProperties;

public class CreateValue {

	SimulProperties simulProperties;
	MetricValues metricValues;
	Field fields[];
	
	public CreateValue(SimulProperties simulProperties)	{
		this.simulProperties = simulProperties;
		metricValues = simulProperties.getMetricValues();
		fields = metricValues.getClass().getDeclaredFields();
		//metricValues.getClass().getDeclaredMethods()
	}
	
	public List<List<CollectdVo>> createCollectdValue(List<CollectdVo> list)	{
		List<List<CollectdVo>> listOfCollectdVo = new ArrayList<List<CollectdVo>>();
		//simulProperties.getMetricValues();
		
		CollectdVo collectdVo;
		
		for(int i=0; i<metricValues.getConfig_value(); i++)	{
			collectdVo = list.get(i);
			
			//deep copy? - 좀 더 쉬운방법을 고려
			CollectdVo simCollectdVo = new CollectdVo();
			simCollectdVo.setDsnames(collectdVo.getDsnames());
			simCollectdVo.setDstypes(collectdVo.getDstypes());
			simCollectdVo.setHost(collectdVo.getHost());
			simCollectdVo.setInterval(collectdVo.getInterval());
			simCollectdVo.setMeta(collectdVo.getMeta());
			
			//비어 있는 경우도 있으니 null check
			if(collectdVo.getPlugin_instance() != null)
				simCollectdVo.setPlugin_instance(collectdVo.getPlugin_instance());
			
			simCollectdVo.setType(collectdVo.getType());
			
			//values - key point
			String plugin = collectdVo.getPlugin();
			String type_instance = collectdVo.getType_instance();
			String prefix = plugin;
			String suffix = type_instance;
			
			simCollectdVo.setPlugin(plugin);
			simCollectdVo.setType_instance(type_instance);
			
			//simCollectdVo.setValues();
		}
		
		return listOfCollectdVo;
	}
	
	public List<List<CollectdWinVo>> createCollectdWinValue(List<CollectdWinVo> list)	{
		List<List<CollectdWinVo>> listOfCollectdWinVo = new ArrayList<List<CollectdWinVo>>();
		CollectdWinVo collectdWinVo;
		for(int i=0; i<metricValues.getConfig_value(); i++)	{
			
		}
		
		return listOfCollectdWinVo;
	}

	public String setPrefix(String inPrefix)	{
		return inPrefix;
	}
	
	//
	public String[] setCustomValue(String inPrefix, String inSuffix, String values[])	{
		
		for(int i=0; i<fields.length; i++)	{
			String fieldName = fields[i].getName();
			if(fieldName.startsWith(inPrefix) && fieldName.endsWith(inSuffix))	{
				//해당하는 metricValue를 get
				
			}
		}
		
		return values;
	}
}
