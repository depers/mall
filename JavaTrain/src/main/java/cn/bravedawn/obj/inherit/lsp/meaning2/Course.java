package cn.bravedawn.obj.inherit.lsp.meaning2;

/**
 * @author : depers
 * @program : design_pattern
 * @description: 课程接口的实现类
 * @date : Created in 2020/8/23 18:25
 */
public class Course {

    private Integer id;
    private String name;
    private Double price;

    public Course(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }
}
