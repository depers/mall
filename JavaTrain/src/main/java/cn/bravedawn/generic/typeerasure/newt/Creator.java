package cn.bravedawn.generic.typeerasure.newt;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/2/25 21:17
 */
public class Creator<T> {

    T instance;

    public <F extends Factory<T>> T newInstance(F f) {
        instance = f.create();
        return instance;
    }

}
