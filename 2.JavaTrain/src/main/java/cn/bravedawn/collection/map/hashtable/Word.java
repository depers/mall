package cn.bravedawn.collection.map.hashtable;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/18 20:20
 */
public class Word {

    /**
     * 工具类
     */


    private String name;

    public Word(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Word{" +
                "name='" + name + '\'' +
                '}';
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Word))
            return false;

        Word word = (Word) o;
        return word.getName().equals(this.name) ? true : false;

    }

    public int hashCode() {
        return name.hashCode();
    }
}
