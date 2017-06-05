import com.xdc.mybatis.bean.Classes;
import com.xdc.mybatis.bean.User;
import com.xdc.mybatis.dao.GetSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/2.
 */
public class UserTest {
    private static Logger logger = Logger.getLogger(UserTest.class);
    SqlSession sqlSession ;
    @Test
    public void insertPerson() {
        sqlSession = GetSqlSessionFactory.getSqlSession();
        int id = 2;
        String userName = "test";
        int age = 18;
        String mobilePhone = "18000000000";
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setAge(age);
        user.setMobilePhone(mobilePhone);
        try {
            sqlSession.insert("insertUser",user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            GetSqlSessionFactory.closeSession(sqlSession);
        }
    }
    @Test
    public void queryById(){
        sqlSession = GetSqlSessionFactory.getSqlSession();
        logger.debug("logSqlSession:"+sqlSession);
        int id = 1;
        try{
            Map user = sqlSession.selectOne("queryById",id);
            logger.debug("logUser:"+user);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            GetSqlSessionFactory.closeSession(sqlSession);
        }

    }

    @Test
    public void getAllById(){
        sqlSession = GetSqlSessionFactory.getSqlSession();
        logger.debug("logSqlSession:"+sqlSession);
        try{
            List user = sqlSession.selectList("getAllUsers");
            logger.debug("logUser:"+user);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            GetSqlSessionFactory.closeSession(sqlSession);
        }

    }


    @Test
    public void getTeacherClass(){
        sqlSession = GetSqlSessionFactory.getSqlSession();
        logger.debug("logSqlSession:"+sqlSession);
        int id = 3;
        try{
            Classes teacherClass = sqlSession.selectOne("getTeacherClass",id);
            logger.debug("logUser:"+teacherClass.toString());
            sqlSession.commit();
            logger.debug("logUser:"+teacherClass.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            GetSqlSessionFactory.closeSession(sqlSession);
        }

    }

    @Test
    public void getStudentTeacherClass(){
        sqlSession = GetSqlSessionFactory.getSqlSession();
        logger.debug("logSqlSession:"+sqlSession);
        int id = 1;
        try{
            Classes studentTeacherClass = sqlSession.selectOne("getStudentTeacherClass",id);
            sqlSession.commit();
            logger.debug("logUser:"+studentTeacherClass.toJSONArray());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            GetSqlSessionFactory.closeSession(sqlSession);
        }

    }

}
