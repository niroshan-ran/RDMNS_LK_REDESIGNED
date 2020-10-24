package com.uee.rdmns_lk_redesigned.mainNewsFeed;

import java.io.Serializable;
import java.sql.Timestamp;

public class NewsFeedModel implements Serializable {

    private String topic;
    private String desc;
    private int image;
    private Timestamp timestamp;
    private String dateTimes;

    public NewsFeedModel() {

    }

    public NewsFeedModel(String topic, String desc, int image) {
        this.topic = topic;
        this.desc = desc;
        this.image = image;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getDateTimes() {
        return dateTimes;
    }

    public void setDateTimes(String dateTimes) {
        this.dateTimes = dateTimes;
    }
}
