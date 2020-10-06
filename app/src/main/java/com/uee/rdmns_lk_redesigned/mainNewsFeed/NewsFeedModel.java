package com.uee.rdmns_lk_redesigned.mainNewsFeed;

import java.io.Serializable;

public class NewsFeedModel implements Serializable {

    private String topic;
    private String desc;
    private int image;

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
}
