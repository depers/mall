package org.slf4j;

import com.alibaba.ttl.TransmittableThreadLocal;
import org.slf4j.spi.MDCAdapter;

import java.util.Deque;
import java.util.Map;

/**
 * @author : depers
 * @program : log4j2-demo
 * @date : Created in 2024/8/6 21:03
 */
public class TtlMDCAdapter implements MDCAdapter {


    private final ThreadLocal<Map<String, String>> copyOnInheritThreadLocal = new TransmittableThreadLocal<>();


    static TtlMDCAdapter mtcMDCAdapter;

    static {
        mtcMDCAdapter = new TtlMDCAdapter();
        // 替换MDC的MDCAdapter
        MDC.mdcAdapter = mtcMDCAdapter;
    }

    public static MDCAdapter getInstance() {
        return mtcMDCAdapter;
    }

    @Override
    public void put(String key, String val) {
        copyOnInheritThreadLocal.get().put(key, val);
    }

    @Override
    public String get(String key) {
        return copyOnInheritThreadLocal.get().get(key);
    }

    @Override
    public void remove(String key) {
        copyOnInheritThreadLocal.get().remove(key);
    }

    @Override
    public void clear() {
        copyOnInheritThreadLocal.remove();
    }

    @Override
    public Map<String, String> getCopyOfContextMap() {
        return Map.of();
    }

    @Override
    public void setContextMap(Map<String, String> contextMap) {

    }

    @Override
    public void pushByKey(String key, String value) {

    }

    @Override
    public String popByKey(String key) {
        return "";
    }

    @Override
    public Deque<String> getCopyOfDequeByKey(String key) {
        return null;
    }

    @Override
    public void clearDequeByKey(String key) {

    }
}
