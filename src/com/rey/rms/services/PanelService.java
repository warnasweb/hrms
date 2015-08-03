package com.rey.rms.services;

import java.util.List;

import com.rey.rms.hibernateBean.PanelBean;

public interface PanelService {
	List<PanelBean> getPanelList();
	PanelBean getPanel(long id);
	void savePanel(PanelBean panelBean);
	
	void updatePanel(PanelBean panelBean);
}
