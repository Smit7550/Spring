package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.RegVo;


@Repository
public class RegDao 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void insert(RegVo regVO)
	{
		try
		{
			 Session session=sessionFactory.openSession();
			 Transaction transaction=session.beginTransaction();
			 session.save(regVO);
			 transaction.commit();
			 session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List search(RegVo regVO1)
	{
		List ls = new ArrayList(); 
		try
		{
			Session session=sessionFactory.openSession();
			 Transaction transaction=session.beginTransaction();
			 Query q = session.createQuery("from RegVo");
				ls = q.list();
			 transaction.commit();
			 session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;	
	}
	
	public void delete(RegVo regVO2)
	{
		try
		{
			
			Session s1 = sessionFactory.openSession();
			
			Transaction t = s1.beginTransaction();

			s1.delete(regVO2);
			
			t.commit();
			
			s1.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List search1(RegVo regVO1)
	{
		List ls = new ArrayList(); 
		try
		{
			Session session=sessionFactory.openSession();
			 Transaction transaction=session.beginTransaction();
			 Query q = session.createQuery("from RegVo where id='"+regVO1.getId()+"'");
				ls = q.list();
			 transaction.commit();
			 session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;	
	}
	public void edit(RegVo regVO3)
	{
		try
		{
			
			Session s1 = sessionFactory.openSession();
			
			Transaction t = s1.beginTransaction();

			s1.update(regVO3);
			
			t.commit();
			
			s1.close();

		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
}
