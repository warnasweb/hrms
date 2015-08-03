package com.rey.rms.dao;

import java.util.List;

import com.rey.rms.hibernateBean.PanelBean;

public interface PanelDAO {
	List<PanelBean> getPanelList();
	PanelBean getPanel(long id);
	void savePanel(PanelBean panelBean);
	
	void updatePanel(PanelBean panelBean);
}
