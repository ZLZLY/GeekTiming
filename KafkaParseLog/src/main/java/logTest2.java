
import java.io.*;

import com.alibaba.fastjson.JSONException;
import  com.alibaba.fastjson.JSONObject;
import  com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;
import  java.util.Map;


public class logTest2 {
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\WeiObjects\\showdata\\src\\main\\resources\\20200315_14.text"),"UTF-8");
        BufferedReader in = new BufferedReader(isr);
        String str = null;
        List<String> temp = new ArrayList<>();

        String eid = "";
        String uid = "";
        String scid = "";
        String video_type = "";
        String channelid = "";
        String anchor_id = "";
        int x = 0;
        int errN = 0;
        int tempSum = 0;
        while ((str = in.readLine()) != null) {
            try {
                x += 1;
                System.out.println("当前已处理样例数量："+String.valueOf( x));

                JSONObject outJson = JSONObject.parseObject(str);
                String msg = outJson.getString("data");
//                System.out.println(msg);
                JSONObject outJson2 = JSONObject.parseObject(msg);
                String msg2 = outJson2.getString("data");
//                System.out.println(msg2);
                JSONObject outJson3 = JSONObject.parseObject(msg2);
                String msg3 = outJson3.getString("log");
//                System.out.println(msg3);

                JSONArray outJsonlist = outJson3.getJSONArray("log");

                if (outJsonlist.size() > 0) {
                    for (int i = 0; i < outJsonlist.size(); i++) {
                        tempSum+=1;
//                    System.out.println(i);
                        JSONObject text = outJsonlist.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
//                        System.out.println(text.getString("ext"));
//                        System.out.println(outJsonlist.getJSONObject(i).getString("ext"));

                        uid = text.getString("uid");
                        eid = text.getString("eid");
                        if (text.containsKey("ext")) {
                            JSONObject extJson = JSONObject.parseObject(text.getString("ext"));
                            video_type = extJson.getString("video_type");
                            channelid = extJson.getString("channelid");
                            anchor_id = extJson.getString("anchor_id");
                            scid = extJson.getString("scid");

                            temp.add("uid:" + uid + "\t" + "eid:" + eid + "\t" + "video_type:" + video_type + "\t" +
                                    "channelid:" + channelid + "\t" + "anchor_id:" + anchor_id + "\t" + "scid:" + scid + " ");
                        }
                    }
                }
            }catch (Exception e){
//                System.out.println(e);
//                errN+=1;
                continue;
            }
        }
        String newNalue = String.join(" ", temp);
        String[] newData = newNalue.split(" ",-1);
        for(String res : newData){
            System.out.println(res);
        }
        System.out.println(newData.length);


//        System.out.println(errN);

    }
}