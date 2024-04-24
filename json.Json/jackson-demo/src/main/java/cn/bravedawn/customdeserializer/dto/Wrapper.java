package cn.bravedawn.customdeserializer.dto;

/**
 * @author : depers
 * @program : jackson-demo
 * @description:
 * @date : Created in 2023/4/13 10:22
 */
public class Wrapper<T> {

    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
