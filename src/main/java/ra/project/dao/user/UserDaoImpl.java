package ra.project.dao.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.project.model.entity.User;

import javax.persistence.TypedQuery;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements IUserDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession(); // mở phiên làm viêc
        Transaction tran = session.beginTransaction();// bắt đàu giao dich (thêm xóa sửa)
        try {
            session.saveOrUpdate(user);
            tran.commit();
        }catch (Exception e){
            // rang buoc du lieu
            tran.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public User loadUserByUsername(String username) {
        Session session = sessionFactory.openSession();
        TypedQuery<User> query = session.createQuery("from User where username= :username and isDeleted = false", User.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }
}
