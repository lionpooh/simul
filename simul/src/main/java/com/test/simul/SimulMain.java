package com.test.simul;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.simul.service.CreateValue;
import com.test.simul.service.JsonToVo;
import com.test.simul.service.SetConfig;
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
    	
    	BufferedReader br = null;
    	//JsonParsing
    	JsonToVo parser = new JsonToVo();
    	//valueSetting
    	CreateValue createValue = new CreateValue(simulProperties);
    	
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
	    	parser.sampleToMetricVo(list);
	    
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		
    }
}
