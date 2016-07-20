package com.test.simul.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
	Method method[];
	
	public CreateValue(SimulProperties simulProperties)	{
		this.simulProperties = simulProperties;
		metricValues = simulProperties.getMetricValues();
		
		//Declared가 붙을 경우 private 까지 get set 할 수가 있다. 
		fields = metricValues.getClass().getDeclaredFields();
		method = metricValues.getClass().getMethods();
		//metricValues.getClass().getDeclaredMethods()
	}
	
	//class info 관련 exception
	public List<List<CollectdVo>> createCollectdValue(List<CollectdVo> list) throws Exception	{
		List<List<CollectdVo>> listOfCollectdVoList = new ArrayList<List<CollectdVo>>();
		//simulProperties.getMetricValues();
		
		CollectdVo collectdVo;
		for(int k=0; k<metricValues.getConfig_value(); k++)	{
			
			List<CollectdVo> collectdVoList = new ArrayList<CollectdVo>();
			
			for(int i=0; i<list.size(); i++)	{
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
				
				Double values[] = setCustomValue(prefix, suffix, k);
				simCollectdVo.setValues(values);
				
				//listOfCollectdVo.add(simCollectdVo);
				collectdVoList.add(simCollectdVo);
			}
			
			listOfCollectdVoList.add(collectdVoList);
		}
		
		return listOfCollectdVoList;
	}
	
	//class info 관련 exception
	public List<List<CollectdWinVo>> createCollectdWinValue(List<CollectdWinVo> list) throws Exception	{
		List<List<CollectdWinVo>> listOfCollectdWinVoList = new ArrayList<List<CollectdWinVo>>();
		CollectdWinVo collectdWinVo;
		
		for(int k=0; k<metricValues.getConfig_value(); k++)	{
			
			List<CollectdWinVo> collectdWinList = new ArrayList<CollectdWinVo>();
			
			for(int i=0; i<list.size(); i++)	{
				collectdWinVo = list.get(i);
				
				CollectdWinVo simCollectdWinVo = new CollectdWinVo();
				simCollectdWinVo.setDsnames(collectdWinVo.getDsnames());
				simCollectdWinVo.setDstypes(collectdWinVo.getDstypes());
				simCollectdWinVo.setHost(collectdWinVo.getHost());
				simCollectdWinVo.setInterval(collectdWinVo.getInterval());
				//time
				simCollectdWinVo.setMeta(collectdWinVo.getMeta());

				String plugin = collectdWinVo.getPlugin();
				String type_instance = collectdWinVo.getType_instance();
				String plugin_instance = null;
				String prefix = plugin;
				String suffix = type_instance;
				
				if(collectdWinVo.getPlugin_instance() != null)	{
					plugin_instance = collectdWinVo.getPlugin_instance();
					simCollectdWinVo.setPlugin_instance(plugin_instance);
				}
				
				simCollectdWinVo.setPlugin(plugin);
				simCollectdWinVo.setType_instance(type_instance);
				
				Double values[] = setCustomValue(prefix, suffix, k);
				simCollectdWinVo.setValues(values);
				
				collectdWinList.add(simCollectdWinVo);
			}
		
			listOfCollectdWinVoList.add(collectdWinList);
		}
		return listOfCollectdWinVoList;
	}

	//설정값에서 지정해둔 값으로 가져옴
	public Double[] setCustomValue(String inPrefix, String inSuffix, int valueNum) throws Exception	{
		
		Double values[] = new Double[1];
		
		if(inPrefix.equals("aggregation"))	{
			inPrefix = "cpu";
		} 
		
		//disk 일 경우
		else if(inPrefix.equals("df"))	{
			
		}
		
		for(int i=0; i<method.length; i++)	{
			String methodName = method[i].getName().toLowerCase();
			//get으로 시작하지 않으면 break
			if(!methodName.startsWith("get"))	{
				break;
			} 
			
			if(methodName.contains(inPrefix) && methodName.endsWith(inSuffix))	{
				//exception들 많이 발생 - 처리?
				Object value = method[i].invoke(metricValues);
				//list로 cast
				List<Double> list = (List<Double>) value;
				values[0] = list.get(valueNum);
			}
		}
		return values;
	}
}
