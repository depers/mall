package cn.bravedawn.service;

/**
 * @Author 冯晓
 * @Date 2020/1/2 19:32
 */
public interface StuService {

    public void saveParent();
    public void saveChildren();

    void saveSelectStuInfo();

    void selectStuInfo();

    void updateSelectStuInfo();
}
