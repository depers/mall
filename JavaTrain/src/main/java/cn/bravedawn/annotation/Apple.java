package cn.bravedawn.annotation;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/3/10 21:45
 */
public class Apple {

    @FruitName("Apple")
    private String appName;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    @FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市延安路89号红富士大厦")
    private String appProvider;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppProvider() {
        return appProvider;
    }

    public void setAppProvider(String appProvider) {
        this.appProvider = appProvider;
    }

    public void disPlayName() {
        System.out.println("水果的名字是：苹果");
    }
}
