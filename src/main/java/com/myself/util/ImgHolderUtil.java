package com.myself.util;

import java.io.InputStream;

/**
 * @Author:这个程序员有纹身
 * @Date: Created in 20:46 2018\1\9 0009
 */
public class ImgHolderUtil {

    private String imageName;
    private InputStream image;

    public ImgHolderUtil(String imageName, InputStream image) {
        this.imageName = imageName;
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }
}
