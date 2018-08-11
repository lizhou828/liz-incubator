package com.liz.multipleThread.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

/**
 * Created by lizhou on 2018年08月11日 15时38分
 */
public class FileUtils {
    /**
     * 下载文件到指定目录下
     * @param url  要下载的文件url地址
     * @param downloadPath 下载指定目录
     * @return
     */
    public static File download(String url, String downloadPath){
        // 取得文件的后缀名
        String ext = url.substring(url.lastIndexOf("."));

        URL urlfile = null;
        HttpURLConnection httpUrl = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        File f = new File(downloadPath + File.separator + UUID.randomUUID() + ext );
        try {
            urlfile = new URL(url);
            httpUrl = (HttpURLConnection) urlfile.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(f));
            int len = 2048;
            byte[] b = new byte[len];
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            bos.flush();
            bis.close();
            httpUrl.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return f;
    }
}
