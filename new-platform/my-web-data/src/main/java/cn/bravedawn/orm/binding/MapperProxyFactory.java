package cn.bravedawn.orm.binding;

import java.lang.reflect.Proxy;

/**
 * @author : fengx9
 * @program : new-platform-main
 * @date : Created in 2023/03/01 2:22 PM
 */
public class MapperProxyFactory<T> {

    /**
     * mapper接口的class对象
     */
    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }


    protected T newInstance(MapperProxy<T> mapperProxy) {
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, mapperProxy);
    }
}
