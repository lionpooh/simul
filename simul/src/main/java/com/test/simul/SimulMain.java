package com.test.simul;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.simul.service.JsonToVo;
import com.test.simul.service.SetConfig;
import com.test.simul.vo.CollectdVo;
import com.test.simul.vo.CollectdWinVo;
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

    	//property - read
    	
    	//gson - parse - vo
    	
    	//join - waiting
    	
    	/*double values = 97.7998781124159;
    	NumberFormat format = NumberFormat.getInstance();
    	format.setGroupingUsed(false);
    	System.out.println(format.format(values));
    	System.out.println(values);*/
    	
    	//test
    	
    	//Field[] fields = CollectdVo.class.getDeclaredFields();
    	
    	//System.out.println(fields[2].getName());
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
    	
    	//json to vo
    	//error - 알맞지 않는 vo에 파싱 에러
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
