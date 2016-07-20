package com.test.simul.service;

import java.util.ArrayList;
import java.util.List;

import com.test.simul.vo.AggConfigVo;
import com.test.simul.vo.CollectdWinVo;
import com.test.simul.vo.SimulProperties;

public class CollectdWinTask implements Runnable{

	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String CONTENT_TYPE = "application/json";
	
	private String POST_URL;
	private String hostName;
	private SimulProperties simulProperties;
	private AggConfigVo aggConfig;
	private int number;
	private List<List<CollectdWinVo>> listOfCollectdWinVoList;
	private List<List<CollectdWinVo>> copyOfList;
	
	CollectdWinTask(String hostName, SimulProperties simulProperties, int number, List<List<CollectdWinVo>> listOfCollectdWinVoList)	{
		this.hostName = hostName;
		this.simulProperties = simulProperties;
		this.aggConfig = simulProperties.getAggConfig();
		this.number = number;
		this.listOfCollectdWinVoList = listOfCollectdWinVoList;
		copyOfList = new ArrayList<List<CollectdWinVo>>();
	}
	
	public void run() {
		
	}

	public void send()	{
		
	}
	
	public void initList()	{
		String host = hostName + String.format("%03d", number);
		//deepcopy
		for(int k=0; k<listOfCollectdWinVoList.size(); k++)	{
			List<CollectdWinVo> tmpList = new ArrayList<CollectdWinVo>();
			CollectdWinVo tmpVo;
			for(int i=0; i<tmpList.size(); i++)	{
				CollectdWinVo copyVo = new CollectdWinVo();
				tmpVo = listOfCollectdWinVoList.get(k).get(i);
				//copy
				copyVo.setDsnames(tmpVo.getDsnames());
				copyVo.setDstypes(tmpVo.getDstypes());				
				copyVo.setHost(host);
				copyVo.setInterval(tmpVo.getInterval());
				copyVo.setMeta(tmpVo.getMeta());
				copyVo.setPlugin(tmpVo.getPlugin());

				if(tmpVo.getPlugin_instance() != null)	{
					copyVo.setPlugin_instance(tmpVo.getPlugin_instance());
				}
				
				copyVo.setType(tmpVo.getType());
				copyVo.setType_instance(tmpVo.getType_instance());
				copyVo.setValues(tmpVo.getValues());
			}
			copyOfList.add(tmpList);
		}
	}
	
	//send 전 현재 시간으로 time value 변경
	public void configTime(List<CollectdWinVo> list)	{
		double time = System.currentTimeMillis();
		time = time / 1000;
		for(int i=0; i<list.size(); i++)	{
			//list.get(i).getTime();
			list.get(i).setTime(time);
		}
	}
}
