package com.agjsj.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.agjsj.entity.Job;
import com.agjsj.entity.User;
import com.agjsj.factory.HibernateSessionFactory;

/*
 * 数据库操作基本类
 * 添加，查询，修改，删除
 * 以面向对象的形式
 */
public class BaseHibernateDAO {

	//添加数据
	protected boolean add(Object object) {
		boolean bool = false;
		Transaction tran = null;
		//获取Session
		Session session = HibernateSessionFactory.getSession();

		try {
			//开始事务
			tran = session.beginTransaction();
			//持久化对象
			session.save(object);
			//提交事务
			tran.commit();
			bool = true;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return bool;
	}
	protected Object addObject(Object object) {
		Transaction tran = null;
		//获取Session
		Session session = HibernateSessionFactory.getSession();

		try {
			//开始事务
			tran = session.beginTransaction();
			//持久化对象
			session.save(object);
			//提交事务
			tran.commit();
			return object;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return null;
	}
	//------------------------------------------------------------------------------------------
	//获取数据 根据用户ID
	protected Object get(Class cla,Serializable id) {
		Object object = null;
		Transaction tran = null;
		Session session = HibernateSessionFactory.getSession();
		try {
			tran = session.beginTransaction();
			
			object = session.get(cla, id);
			
			tran.commit();
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return object;
	}
	//获取用户整个信息 根据条件语句
	protected List getByHql(String hql) {
		List list = null;
		Transaction tran = null;
		Session session = HibernateSessionFactory.getSession();
		try {
			tran = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			//执行查询获取结果 
			list = query.list();
			
			tran.commit();
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return list;
	}

	protected boolean isExistByHql(String hql) {
		Object[] obj = null;
		boolean bool = false;
		//执行查询获取结果 
		List list;
		try {
			Session session = HibernateSessionFactory.getSession();
			//		String hql = "from Books books where books.title=:bookTitle ";
			Query query = session.createQuery(hql);
			list = query.list();
			if(list.size() > 0){
				System.out.println(list.get(0));
				bool = true;
			}
		} catch (HibernateException e) {
			System.out.println("不存在此用户名");
		}
		
		return bool;
	}
	
	/**
	 * 获取指定条数的分页查询
	 * @param count
	 * @param start
	 * @param hql
	 * @return
	 */
	protected List getPageList(Integer count,Integer start,String hql) {
		List list = null;
		Transaction tran = null;
		Session session = HibernateSessionFactory.getSession();
		try {
			tran = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(count);
			list = query.list();
			tran.commit();
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return list;
	}
	
	/**
	 * 按属性降序排列 分页加载
	 * @param count	
	 * @param start
	 * @param mclass	对象class文件
	 * @param str	属性
	 * @return
	 */
	protected List getPageListByQBC(Integer count,Integer start,Class mclass,String str) {
		List list = null;
		Transaction tran = null;
		Session session = HibernateSessionFactory.getSession();
		try {
			tran = session.beginTransaction();
			//创建对象
			Criteria criteria = session.createCriteria(mclass);
			//对查询结果按降序排列
			criteria.addOrder(Order.desc(str));
			//分页查询
			criteria.setFirstResult(start);
			criteria.setMaxResults(count);
			list = criteria.list();
			tran.commit();
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
//		try {
//			Session session = HibernateSessionFactory.getSession();
//		
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		}
		return list;
	}
	protected List getPageListByQBC(Integer count,Integer start,Class mclass,String str
			,String eq,Object value) {
		List list = null;
		Transaction tran = null;
		Session session = HibernateSessionFactory.getSession();
		try {
			tran = session.beginTransaction();
			//创建对象
			Criteria criteria = session.createCriteria(mclass);
			//查询条件
			criteria.add(Restrictions.eq(eq, value));
			//对查询结果按降序排列
			criteria.addOrder(Order.desc(str));
			//分页查询
			criteria.setFirstResult(start);
			criteria.setMaxResults(count);
			list = criteria.list();
			tran.commit();
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
//		try {
//			Session session = HibernateSessionFactory.getSession();
//		
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		}
		return list;
	}
	//------------------------------------------------------------------------------------------
	//删除数据
	protected boolean delete(Object object) {
		boolean bool = false;
		Transaction tran = null;
		Session session = HibernateSessionFactory.getSession();
		try {
			tran = session.beginTransaction();
			System.out.println(object.toString());
			session.delete(object);
			tran.commit();
			bool = true;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return bool;
	}
//---------------------------------------------------------------------------------------------------
	/*
	 * 									修改数据
	 */
	//修改数据
	protected boolean update(Object object) {
		Transaction tran = null;
		boolean bool = false;
		Session session = HibernateSessionFactory.getSession();
		try {
			tran = session.beginTransaction();
			session.update(object);
			tran.commit();
			bool = true;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		return bool;
	}
	
	/**
	 * 修改数据或删除数据通过hql
	 * @param hql
	 * @return
	 */
	protected boolean updateOrDeleteByHql(String hql) {
		Transaction tran = null;
		boolean bool = false;
		int ret = 0;
		Session session = HibernateSessionFactory.getSession();
		try {
			tran = session.beginTransaction();
			Query query = session.createQuery(hql);
			ret = query.executeUpdate();
			tran.commit();
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		if (ret > 0) {
			bool = true;
		}
		return bool;
	}
	
	protected boolean updateBaseUser(Integer user_id,User user){
		Transaction tran = null;
		boolean bool = true;
		Session session = HibernateSessionFactory.getSession();
		User localuser = (User) session.get(User.class, user_id);
		System.out.println("localuser:"+localuser);
		localuser.setUserSex(user.getUserSex());
		localuser.setUserBirthdate(user.getUserBirthdate());
		localuser.setUserEmail(user.getUserEmail());
		localuser.setUserAddress(user.getUserAddress());
		localuser.setUserAddressinfo(user.getUserAddressinfo());
		try {
			tran = session.beginTransaction();
			session.update(localuser);
			tran.commit();
			bool = true;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			bool = false;
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		return bool;
		
	}

}
