package controller;

import jakarta.persistence.NamedQuery;
import model.Category;
import org.hibernate.Session;

import java.util.List;


public class QueryCategory {
    Session session;
    public QueryCategory(){};
    public QueryCategory(Session session){
        this.session = session;
    }

    public List<Category> selectAllCategories(){
        return session.createNamedQuery("Category.SelectAllCategories", Category.class)
                .getResultList();
    }

    public List<Category> selectCategoryWithID(Integer id){
        return session.createNamedQuery("Category.SelectCategoryWithId", Category.class)
                .setParameter("id",id)
                .getResultList();
    }

    public List<Category> selectCategoryWithName(String categoryName){
        return session.createNamedQuery("Category.SelectCategoryWithName", Category.class)
                .setParameter("categoryName",categoryName)
                .getResultList();
    }
}
