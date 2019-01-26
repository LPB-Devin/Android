package com.exmply.swiperefresh;
/**
* 重新定义一个列表类，存放数据内容文本以及图片url
*
*/
public class ImageListArray {
    private String name;
    private int imageUrl;
    public ImageListArray(String name, int imageId){
        this.name = name;
        this.imageUrl = imageId;
    }
    public String getName() {
        return name;
    }
    public int getImageUrl() {
        return imageUrl;
    }
}
