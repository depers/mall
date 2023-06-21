package cn.bravedawn.jvm.chapter10.NameCheckProcessor;

import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementScanner8;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/5/30 18:40
 */
public class NameCheckScanner extends ElementScanner8<Void, Void> {

    /**
     * 此方法用于检测Java类
     * @param e  the element to visit
     * @param unused  a visitor-specified parameter
     * @return
     */
    @Override
    public Void visitType(TypeElement e, Void unused) {
        scan(e.getTypeParameters(), unused);
        return null;
    }
}
