package cn.bravedawn.orm.binding;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : fengx9
 * @program : new-platform-main
 * @date : Created in 2023/03/01 2:25 PM
 */
public class MapperRegistry {


    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();
}
