package com.rey.rms.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.rey.rms.hibernateBean.PanelBean;



public class Utility {

	
	public static Map<Long, String>  getPanels(List<PanelBean> panelList){
		Map<Long, String> panelMap = new LinkedHashMap<Long, String>();
		for(PanelBean panelBean: panelList){
			panelMap.put(panelBean.getId(), panelBean.getFirstName()+" "+panelBean.getLastName());
		}
		
		return panelMap;
	}
	
	public static String formatDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		if(date!=null){
			String formattedDate = formatter.format(date);
			return formattedDate;
		}else{
			return "";
		}
		
	}
}
