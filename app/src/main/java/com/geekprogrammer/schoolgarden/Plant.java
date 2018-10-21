package com.geekprogrammer.schoolgarden;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public class Plant {
    private Bitmap pathImage;
    private String name;
    private String scienceName;
    private String use;
    private int resource;

    public Plant() {
    }

    public Plant(Bitmap pathImage, String name, String scienceName, String use, int resource) {
        this.pathImage = pathImage;
        this.name = name;
        this.scienceName = scienceName;
        this.use = use;
        this.resource = resource;
    }

    public Plant(String name, String scienceName, String use, int resource) {
        this.name = name;
        this.scienceName = scienceName;
        this.use = use;
        this.resource = resource;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public Bitmap getPathImage() {
        return pathImage;
    }

    public void setPathImage(Bitmap pathImage) {
        this.pathImage = pathImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScienceName() {
        return scienceName;
    }

    public void setScienceName(String scienceName) {
        this.scienceName = scienceName;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }
}
