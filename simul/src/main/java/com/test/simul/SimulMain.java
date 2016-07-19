package com.test.simul;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.simul.service.SetConfig;
import com.test.simul.vo.CollectdVo;
import com.test.simul.vo.SettingsConfigVo;
import com.test.simul.vo.SimulProperties;

public class SimulMain {
    public static void main( String[] args ) {
        
    	StringUtils su = new StringUtils();
    	
    	Logger logger = LoggerFactory.getLogger(SimulMain.class);
    	
    	String configPath = null;
    	String type = null;
    	//get arguments
    	if(args.length > 0)	{
    		configPath = args[0];
    	} else {
    		//logger.debug("set filepath to default");
    	}
    	
    	SetConfig setConfig = new SetConfig(configPath);
    	SimulProperties simulProperties = new SimulProperties();
    	SettingsConfigVo settingsConfig = null;
    	
    	Gson gson = new GsonBuilder().serializeNulls().create();
    	
    	//property - read
    	
    	//gson - parse - vo
    	
    	//join - waiting
    	
    	try {
    		String tmp;
    		BufferedReader br = new BufferedReader(new FileReader("D:/collectdwin.txt"));
    		
    		/*while((tmp = br.readLine()) != null)	{
    			//System.out.println(tmp);
    		}*/
    		tmp = br.readLine();
    		Object[] obj = gson.fromJson(tmp, Object[].class);
    		Map map = (Map) obj[0];
    		String mapTmp = (String) map.get("plugin_instance");
    		//mapTmp = su.center(mapTmp, 10);
    		//System.out.println("공백 : " + mapTmp + "/");
    		if(mapTmp.isEmpty())	{
    			//System.out.println("null!");
    			//map.put("plugin_instance", "\0");
    			//map.remove("plugin_instance");
    		}
    		
    		CollectdVo collectdVo = gson.fromJson(map.toString(), CollectdVo.class);
    		String after = gson.toJson(collectdVo);
    		System.out.println("after: " + after);
    		CollectdVo collectdVo2 = gson.fromJson(after, CollectdVo.class);
    		String after2 = gson.toJson(collectdVo2);
    		System.out.println(after2);
    		
    	} catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	/*double values = 97.7998781124159;
    	NumberFormat format = NumberFormat.getInstance();
    	format.setGroupingUsed(false);
    	System.out.println(format.format(values));
    	System.out.println(values);*/
    	
    	
    	//test
    	
    	/*BufferedReader br = null;
    	JsonToVo parser = new JsonToVo();
    	List<String> list = new ArrayList<String>();
    	String tmp = null;
    	
    	try {
    		
			simulProperties = setConfig.insertConfig();
			type = simulProperties.getSimulType();
			settingsConfig = simulProperties.getSettingsConfig();
			br = new BufferedReader(new FileReader(settingsConfig.getFilePath()));
			
			//file read
	    	while((tmp = br.readLine()) != null)	{
	    		list.add(tmp);
	    	}
    	
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if(type.equals("collectd"))	{
    		parser.sampleToCollectdVo(list);
    	} 
    	
    	else if(type.equals("collectdwin"))	{
    		parser.sampleToCollectdWinVo(list);
    	} 
    	
    	else	{
    		logger.error("error");
    	}*/
    		
    }
}
