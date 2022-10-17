package cn.bravedawn.collection.map.concurrentskiplistmap.example;

import java.time.ZonedDateTime;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/16 17:34
 */
public class Event {

    /**
     * 事件实体类
     */

    private ZonedDateTime eventTime;
    private String content;

    public Event(ZonedDateTime eventTime, String content) {
        this.eventTime = eventTime;
        this.content = content;
    }

    public ZonedDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(ZonedDateTime eventTime) {
        this.eventTime = eventTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
