package com.liz.incubator.utils;

import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 <dependency>
 <groupId>com.itextpdf.tool</groupId>
 <artifactId>xmlworker</artifactId>
 <version>5.5.9</version>
 </dependency>

 <dependency>
 <groupId>com.itextpdf</groupId>
 <artifactId>itext-asian</artifactId>
 <version>5.2.0</version>
 </dependency>

 <dependency>
 <groupId>org.xhtmlrenderer</groupId>
 <artifactId>flying-saucer-pdf-itext5</artifactId>
 <version>9.0.3</version>
 </dependency>


 注意：

 输入的 HTML 页面必须是标准的 XHTML 页面。页面的顶上必须是这样的格式：
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <html xmlns="http://www.w3.org/1999/xhtml">
 语法必须是标准的 HTML 语法：所有标签都必须闭合
 CSS 中必须指定字体，然后在 Java 代码中设置相应的字体


 作者：chenxc
 链接：https://hacpai.com/article/1536549807193
 来源：黑客派
 协议：CC BY-SA 4.0 https://creativecommons.org/licenses/by-sa/4.0/



 * Created by Administrator on 2020/1/10.
 */
public class FileTypeConvertUtil {
    /**
     * 将HTML转成PD格式的文件。html文件的格式比较严格
     * @param pdfFile
     * @throws Exception
     */
    // <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd ">
    public static void html2pdf( String pdfFile) throws Exception {
        // step 2
        OutputStream os = new FileOutputStream(pdfFile);
        ITextRenderer renderer = new ITextRenderer();
        String content = "<p>我爱世界ads 2asa.!@#!@$#<img src=\"https://diyunzhituo.oss-cn-shenzhen.aliyuncs.com/image/005ExCkSgy1fxsf23hpwsj30kf0ht0uv.jpg\" style=\"width: 690px;\"/></p>";

        String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\"/>\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "    <meta name=\"keywords\" content=\"\" />\n" +
                "    <title>土地政策详情</title>\n" +
                "\n" +
                "    <!--[if  IE 8]>\n" +
                "    <style>\n" +
                "        body{\n" +
                "            font-family: SimSun;\n" +
                "            font-size: 12.0pt;\n" +
                "        }\n" +
                "    </style>\n" +
                "    <![endif]-->\n" +
                "</head>\n" +
                "<body style=\"font-family: SimSun;font-size: 12.0pt;\">\n" +
                "\n" + content+
                "</body>\n" +
                "</html>";
        renderer.setDocumentFromString(html);

        // 图片为本地的绝对路径时,如http://www.baidu.com/a.jpg,则为<img src="a.jpg" />
        renderer.getSharedContext().setBaseURL("http://www.baidu.com/");

        // 图片为HTTP链接时，src只需填写相对路径，如D:/a.jpg,则为<img src="a.jpg" />
        renderer.getSharedContext().setBaseURL("file:/D:/");

        // step 3 解决中文支持
        ITextFontResolver fontResolver = renderer.getFontResolver();
        if(getCurrentOperatingSystem().contains("linux")){
            fontResolver.addFont("/usr/share/fonts/chiness/simsunb.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        }else{
            fontResolver.addFont("C:\\Windows\\Fonts\\simsunb.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        }

        renderer.layout();
        renderer.createPDF(os);
        os.close();

        System.out.println("create pdf done!!");

    }

    public static String getCurrentOperatingSystem(){
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("---------当前操作系统是-----------" + os);
        return os;
    }


    public static void main(String[] args) {
        String pdfFile = "E:/ami.pdf";
        try {
            FileTypeConvertUtil.html2pdf( pdfFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
