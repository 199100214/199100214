





//取得代理类对象的工厂模式
public class ServiceFactory {
    private static Object getService(Object service){
        return  new TransactionInvocationHandler(service).getProxy();
    }
}
