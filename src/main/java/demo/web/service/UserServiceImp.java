package demo.web.service;

import demo.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChinhVD on 11/1/17.
 */
@Repository
public class UserServiceImp extends JdbcDaoSupport implements UserService {


    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public User getUserByLogin(String name, String pass) {
        String sql = "SELECT * FROM user.User where username='"+name+"' and password='"+pass+"'";
        User user = null;
        try {
            user = (User) getJdbcTemplate().queryForObject(
                    sql, new BeanPropertyRowMapper(User.class));
        } catch (EmptyResultDataAccessException e) {

        }
        return user;
    }

    @Override
    public void updateUser(User user) {

        if (user.getId() > 0) {
            String sql = "UPDATE User SET fullname=?, phone=? WHERE id=?";
            getJdbcTemplate().update(sql, user.getFullname(), user.getPhone(), user.getId());
        }
    }

    @Override
    public List<User> listUser() {
        return new ArrayList<>();
    }
}
