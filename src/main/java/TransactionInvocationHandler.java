import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//Spring Aoc的底层原理实现
public class TransactionInvocationHandler implements InvocationHandler {
    private Object target;
    public TransactionInvocationHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession sqlSession = null;
        Object obj = null;
        try{
            sqlSession = util.getSession();
            //处理业务逻辑
            obj = method.invoke(target,args);
            //提交事务
            sqlSession.commit();
        }catch (Exception e){
            //如果出问题 就进行事务回滚
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            util.sqlSessionClose(sqlSession);
        }
        return obj;
    }
    public Object getProxy(){
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
