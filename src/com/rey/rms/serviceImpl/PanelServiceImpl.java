package com.rey.rms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rey.rms.dao.PanelDAO;
import com.rey.rms.hibernateBean.PanelBean;
import com.rey.rms.services.PanelService;

@Service("panelService")
public class PanelServiceImpl implements PanelService {

	@Autowired
	PanelDAO panelDAO;

	@Override
	public List<PanelBean> getPanelList() {
		// TODO Auto-generated method stub
		return panelDAO.getPanelList();
	}

	@Override
	public PanelBean getPanel(long id){
		return panelDAO.getPanel(id);
	}
	@Override
	public void savePanel(PanelBean panelBean) {
		// TODO Auto-generated method stub
		panelDAO.savePanel(panelBean);
	}

	@Override
	public void updatePanel(PanelBean panelBean) {
		// TODO Auto-generated method stub
		panelDAO.updatePanel(panelBean);		
	}
	
	

}
