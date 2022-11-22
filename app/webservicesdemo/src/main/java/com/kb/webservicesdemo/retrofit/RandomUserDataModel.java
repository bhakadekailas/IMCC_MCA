package com.kb.webservicesdemo.retrofit;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

public class RandomUserDataModel implements Serializable {
    private Data data;

    private Support support;

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Support getSupport() {
        return this.support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public static class Data implements Serializable {
        private String last_name;

        private Integer id;

        private String avatar;

        private String first_name;

        private String email;

        public String getLast_name() {
            return this.last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public Integer getId() {
            return this.id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getFirst_name() {
            return this.first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getEmail() {
            return this.email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "last_name='" + last_name + '\'' +
                    ", id=" + id +
                    ", avatar='" + avatar + '\'' +
                    ", first_name='" + first_name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }

    public static class Support implements Serializable {
        private String text;

        private String url;

        public String getText() {
            return this.text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Support{" +
                    "text='" + text + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RandomUserDataModel{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }
}
