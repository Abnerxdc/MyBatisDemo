package com.xdc.mybatis.dao;




import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Administrator on 2017/6/2.
 */
    public class GetSqlSessionFactory {
    private final  static SqlSessionFactory sqlSessionFactory;
    private static Logger logger = Logger.getLogger(GetSqlSessionFactory.class);
    static {
        String resource="mybatis-config.xml";
        Reader reader =null;
        try {
            reader = Resources.getResourceAsReader(resource);
            logger.debug("debugReader:"+reader);
        } catch (IOException e) {
            logger.debug("readerDefault");
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        logger.debug("debugSqlSessionFactory:"+sqlSessionFactory);
    }

    /**
     * 获取SqlSessionFactory
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    /**
     * 获取SqlSession
     * @return SqlSession
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
    /**
     * 关闭SqlSession
     */
    public  static void closeSession(SqlSession sqlSession){
        if (sqlSession!=null)
            sqlSession.close();
    }
}
