package cn.bravedawn.obj.inherit.lsp.meaning2;

/**
 * @author : depers
 * @program : design_pattern
 * @description: 打折课程
 * @date : Created in 2020/8/23 18:36
 */
public class DiscountCourse extends Course{

    public DiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    /**
     * 返回原价
     * @return
     */
    public Double getOriginPrice(){
        return super.getPrice();
    }

    /**
     * 这样写其实违背了里式替换原则，子类不能够覆盖父类的非抽象方法
     * @return
     */
    @Override
    public Double getPrice() {
        return super.getPrice() * 0.8;
    }

    /**
     * 应该单独扩展子类的方法去实现子类的功能
     * @return
     */
    public Double getDiscountPrice(){
        return super.getPrice() * 0.8;
    }

}
