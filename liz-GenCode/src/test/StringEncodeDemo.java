import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lizhou on 2016/7/7.
 */
public class StringEncodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        String src = new String("Hello你好啊啊");
//        System.out.println("src="+src);
//
//        String srcGBK = new String(src.getBytes(),"GBK");
//        System.out.println("srcGBK="  + srcGBK );
//
//        String srcUTF_8 = new String(src.getBytes(),"UTF-8");
//        System.out.println("srcUTF_8="  + srcUTF_8 );


//        String str="字符串编码转换";
//        try {
//            byte[] temp=str.getBytes("utf-8");//这里写原编码方式
//            byte[] newtemp=new String(temp,"utf-8").getBytes("gbk");//这里写转换后的编码方式
//            String newStr=new String(newtemp,"gbk");//这里写转换后的编码方式
//            System.out.println(newStr);
//        } catch (UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        String src = "1,2,3,4,5,6,7";

        //每组多少个元素
        int perUnitCount = 3;
        String srcArray[] = src.split(",");
        //有多少组
        int groupNum = srcArray.length % perUnitCount != 0 ? srcArray.length / perUnitCount +1 : srcArray.length / perUnitCount;

        List<String> resultList = new ArrayList<String>();
        for(int i = 0 ;i < groupNum; i++){
            String everyGroup []= new String[perUnitCount];
            for(int j = 0 ;j<perUnitCount;j++){
                if((j + i*perUnitCount) < srcArray.length ){
                    everyGroup[j] = srcArray[j + i*perUnitCount];
                }
            }
            System.out.println("everyGroup="+Arrays.asList(everyGroup));
        }
//        System.out.println("resultList="+resultList);

    }

}
