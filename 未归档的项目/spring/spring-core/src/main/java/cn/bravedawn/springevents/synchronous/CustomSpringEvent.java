package cn.bravedawn.springevents.synchronous;

import org.springframework.context.ApplicationEvent;

/**
 * @author : depers
 * @program : spring-core
 * @description: 自定义spring事件
 * @date : Created in 2021/12/23 8:11
 */
public class CustomSpringEvent extends ApplicationEvent {


    private String message;

    public CustomSpringEvent(final Object source, final String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
