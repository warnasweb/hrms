package com.rey.rms.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rey.rms.dao.PanelDAO;
import com.rey.rms.hibernateBean.PanelBean;

@Repository("panelDAO")
public class PanelDAOImpl implements PanelDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<PanelBean> getPanelList() {
		
		return (List<PanelBean>) sessionFactory.openSession().createCriteria(PanelBean.class).list();
	}
	
	
	public PanelBean getPanel(long id) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Criteria criteria = session
					.createCriteria(PanelBean.class);
			criteria.add(Restrictions.eq("id", id));
			List<PanelBean> lst = (List<PanelBean>)criteria.list();
			if (lst != null && lst.size() > 0) {
				return lst.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void savePanel(PanelBean panelBean) {
		// TODO Auto-generated method stub
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(panelBean);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void updatePanel(PanelBean panelBean) {
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.update(panelBean);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
	
	
	
	
		

}
