package cn.bravedawn.generic.border;

import cn.bravedawn.generic.genericclass.Generic;

public class TopBorderExample2 {


    public <T extends Number> T showKeyName(Generic<T> container) {
        System.out.println("container key: " + container.getKey());
        T test = container.getKey();
        return test;
    }
}
