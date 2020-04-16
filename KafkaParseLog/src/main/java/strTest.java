
import java.io.*;

import com.alibaba.fastjson.JSONException;
import  com.alibaba.fastjson.JSONObject;
import  com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import  java.util.Map;


public class strTest {
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
                System.out.println(msg);
                JSONObject outJson2 = JSONObject.parseObject(msg);
                String msg2 = outJson2.getString("data");
                System.out.println(msg2);
                JSONObject outJson3 = JSONObject.parseObject(msg2);
                String msg3 = outJson3.getString("log");
                System.out.println(msg3);

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

                            temp.add(uid + "\t" + eid + "\t" + video_type + "\t" +
                                    channelid + "\t" + anchor_id + "\t" + scid);
                        }
                    }
                }
            }catch (Exception e){
//                System.out.println(e);
//                errN+=1;
                continue;
            }
        }

        int xxxx = 0;
        int yyyy = 0;
        List<String> eids = new ArrayList<>(Arrays.asList("10004001","10003003"));
        for(int i = 0; i <temp.size()-1;++i){
//            String eid_temp = temp.get(i).split("\t")[1];
//            String channelid_temp1 = temp.get(i).split("\t")[3];
            String[] fields = temp.get(i).split("\t");
//            System.out.println(temp.get(i));
            if(fields.length!=6){
                continue;
            }
            String uid1 = fields[0], eid1 = fields[1], scid1 = fields[5], video_type1 = fields[2], channelid1 = fields[3],anchor_id1 = fields[4];
//            System.out.println(channelid_temp1);
            if(uid1.equals("null") || scid1.equals("null") || video_type1.equals("null") || channelid1.equals("null") ){
                xxxx+=1;
//                System.out.println("xxxx:"+temp.get(i));
            }
            if(!uid1.equals("null") && !scid1.equals("null") && !video_type1.equals("null") && !channelid1.equals("null") && !anchor_id1.equals("null") && eids.contains(eid1)){
                if(uid1.length() > 1 && eids.contains(eid1) && video_type1.equals("1") && channelid1.equals("2")){
                    yyyy+=1;
                    System.out.println("yyyy:"+temp.get(i));
                }

            }
//&& video_type1.equals("1") && channelid1.equals("1")
        }
//        System.out.println(temp.size());
        System.out.println(xxxx);
        System.out.println(yyyy);
        System.out.println(temp.size());


//        System.out.println(errN);

    }
    public static String getType(Object o) { //获取变量类型方法
        return o.getClass().toString(); //使用int类型的getClass()方法
    }
}