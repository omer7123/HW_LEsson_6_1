package com.ripalay.hw_lesson_6_1.ui;

public class Model {
    private int type;
    private int image;
    private String title;

    public Model(int type, int image, String title) {
        this.type = type;
        this.image = image;
        this.title = title;
    }

    public Model(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
