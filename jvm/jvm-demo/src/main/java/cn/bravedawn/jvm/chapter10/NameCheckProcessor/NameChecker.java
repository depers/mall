package cn.bravedawn.jvm.chapter10.NameCheckProcessor;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/5/30 17:41
 */
public class NameChecker {

    private final Messager messager;

    public NameChecker(ProcessingEnvironment processingEnv) {
        this.messager = processingEnv.getMessager();
    }

    public void checkName(Element element) {


    }
}
