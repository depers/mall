package cn.bravedawn.annotation.fruitexample;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/3/10 21:45
 */

@Fruit(name = "苹果")
public class Apple {

    @FruitName("Apple")
    private String name;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String color;

    @FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市延安路89号红富士大厦")
    private String provider;

    @Constructor("这个是构造函数上面的注解")
    public Apple(String name, String color, String provider) {
        this.name = name;
        this.color = color;
        this.provider = provider;
    }

    @Method("这个是方法上的注解")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void disPlayName() {
        System.out.println("水果的名字是：苹果");
    }
}
