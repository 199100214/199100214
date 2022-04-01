import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class util {
    //方法私有化 只能通过我这个方法去掉我这个
    private util(){

    }
    private static SqlSessionFactory sqlSessionFactory;

    static{
        String config = "Mybatis-config";
        InputStream inputStream = null;
        try {
            inputStream= Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    private static ThreadLocal<SqlSession> t = new ThreadLocal<SqlSession>();



    public static SqlSession getSession(){
        SqlSession sqlSession = t.get();
        if (sqlSession != null){
            sqlSession = sqlSessionFactory.openSession();
            t.set(sqlSession);

        }
        return sqlSession;

    }
    public static void sqlSessionClose(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
            t.remove();//线程和连接剥离开
        }
    }
}
