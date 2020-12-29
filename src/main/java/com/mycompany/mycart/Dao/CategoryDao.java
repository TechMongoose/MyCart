/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mycart.Dao;

import com.mycompany.mycart.entities.Category;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
public class CategoryDao {
    private SessionFactory factory;

    public CategoryDao(SessionFactory factory) {
        this.factory = factory;
    }
    //save the category to db
    public int saveCategory(Category cat)
    {
         Session session = this.factory.openSession();
         Transaction tx = session.beginTransaction();
         int catId=(int) session.save(cat);
         tx.commit();
         session.close();
         return catId;
    }
    public List<Category> getCategories(){
        List<Category> categories = null;
        try{
           String query="from Category";
           Session session = this.factory.openSession();
           Query q = session.createQuery("from Category");
           
           
           categories = q.list();
           session.close();
           
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return categories;
    }
    public Category getCategoryById(int cid)
    {
         Category cat = null;
       try{
           Session session = this.factory.openSession();
           cat = session.get(Category.class, cid);
           session.close();
       }catch (Exception e) {
           e.getStackTrace();
       }
       return cat;
    }
}
