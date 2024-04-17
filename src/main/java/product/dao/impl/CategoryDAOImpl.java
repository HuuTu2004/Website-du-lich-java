package product.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import product.dao.CategoryDAO;
import product.entites.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Category findById(int id) {
    	Session session = sessionFactory.openSession();
        try {
           Category cat = session.get(Category.class, id);
            return cat;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
        	session.close();
		}
    }

    @Override

    public boolean insert(Category category) {
    	Session session = sessionFactory.openSession();
        try {
        	session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
           
        }finally {
        	session.close();
		}
        return false;
    }

    @Override
    public boolean update(Category category) {
    	Session session = sessionFactory.openSession();
        try {
        	session.beginTransaction();
			session.update(category);
			session.getTransaction().commit();
         
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }finally {
        	session.close();
		}
    }

    @Override
    public boolean delete(Integer category) {
    	Session session = sessionFactory.openSession();
        try {
        	session.beginTransaction();
            session.delete(findById(category));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }finally {
        	session.close();
		}
    }

    @Override
    public List<Category> getAllCategories() {
    	Session session = sessionFactory.openSession();
        try {
           
            List<Category> list = session.createQuery("FROM Category", Category.class).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
        	session.close();
		}
    }
}
