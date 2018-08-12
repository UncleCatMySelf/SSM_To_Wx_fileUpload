package com.myself.util;

/**
 * @Author:这个程序员有纹身
 * @Date: Created in 20:20 2018\1\9 0009
 */
public class PathUtil {
    private static String seperator = System.getProperty("file.separator");

    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")){
            basePath="D:/mobookImage/image";
        }else{
            basePath = "/Users/mobook/work/image";
        }
        basePath = basePath.replace("/",seperator);
        return basePath;
    }

    public static String getImagePath(int bookId){
        String imagePath = "/upload/images/item/book/"+bookId+"/";
        return imagePath.replace("/",seperator);
    }

    public static String getCodePath(String scence){
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")){
            basePath="D:/mobookImage/image";
        }else{
            basePath = "/Users/mobook/work/image";
        }
        basePath = basePath.replace("/",seperator);
        String imagePath = basePath+"/upload/images/item/code/"+scence+"/";
        return imagePath.replace("/",seperator);
    }

}
