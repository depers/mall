package cn.bravedawn.obj.object.equalsandhashcode.equals;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/26 13:22
 */
public class Voucher {

    /**
     * 使用组合修复equals()的对称性
     *
     * 总结：涉及到继承关系的两个类，若在子类中翻写了equals方法，对于子类和父类实例使用equals方法他就是违背 对称性原则的。利用组合修复
     *      对称性的方法，我没有想到好的使用场景
     */

    private String store;
    private Money value;

    public Voucher(int amount, String currencyCode, String store) {
        this.value = new Money(amount, currencyCode);
        this.store = store;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public boolean equals(Object o) {
        if (o == this) return true;

        if (!(o instanceof Voucher)) {
            return false;
        }

        Voucher other = (Voucher) o;
        boolean valueEquals = (this.value == null && other.value == null) || (this.value != null && this.value.equals(other.value));
        boolean storeEquals = (this.store == null && other.store == null) || (this.store != null && this.store.equals(other.store));
        return valueEquals && storeEquals;
    }


    /**
     * 经过下面的实验，在Voucher类中我们去除了原有对Money类的继承关系
     * 我们通过将Money作为本类的一个属性，也就是通过组合方式集成到这个类中，但是这个类解决了什么问题呢？目前我没有想到这个有什么应用场景
     *
     */

    public static void main(String[] args) {
        Money cash = new Money(42, "USD");

        Voucher voucher = new Voucher(42, "USD", "Amazon");
        Voucher voucher2 = new Voucher(cash.getAmount(), cash.getCurrencyCode(), "Amazon");

        System.out.println(cash.equals(voucher));       // false
        System.out.println(voucher.equals(cash));       // false
        System.out.println(voucher.equals(voucher2));   // true
    }


}
