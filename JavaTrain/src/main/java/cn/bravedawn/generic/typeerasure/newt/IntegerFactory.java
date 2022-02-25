package cn.bravedawn.generic.typeerasure.newt;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/2/25 21:19
 */
public class IntegerFactory implements Factory<Integer>{


    @Override
    public Integer create() {
        Integer integer = new Integer(9);
        return integer;
    }
}
