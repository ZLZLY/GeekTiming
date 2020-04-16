
import java.io.*;

import  com.alibaba.fastjson.JSONObject;
import  com.alibaba.fastjson.JSONArray;
import  java.util.Map;

public class Log {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("D:\\WeiObjects\\showdata\\src\\main\\resources\\20200315_14.text"));
            String str;
            while ((str = in.readLine()) != null) {
                JSONObject outJson = JSONObject.parseObject(str);
                String msg = outJson.getString("data");

                JSONObject outJson2 = JSONObject.parseObject(msg);
                String msg2 = outJson2.getString("data");

                JSONObject outJson3 = JSONObject.parseObject(msg2);
                JSONArray jsonArray = (JSONArray) outJson3.get("log");
                //System.out.println(msg);
                if (jsonArray.size() > 0) {
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject text = jsonArray.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                        if(text.containsKey("eid")) {
                            String ext = text.getString("ext");
                            String eid = text.getString("eid");
                            if (eid.equals("10003003")) {
                                System.out.println(msg2);
                                JSONObject outJson4 = JSONObject.parseObject(ext);
                                if(outJson4.containsKey("channelid")){
                                    String channelid=outJson4.getString("channelid");
                                    if(channelid.equals("2")) {
                                        for (Map.Entry<String, Object> entry : outJson4.entrySet()) {
                                            System.out.println(entry.getKey() + ":" + entry.getValue());
                                        }
                                        System.out.println("------222----");
                                    }else {

                                        for (Map.Entry<String, Object> entry : outJson4.entrySet()) {
                                            System.out.println(entry.getKey() + ":" + entry.getValue());
                                        }

                                        System.out.println("-----no 222-----");
                                    }
                                    System.out.println("-----contain channelid -----");
                                }else{

                                    for (Map.Entry<String, Object> entry : outJson4.entrySet()) {
                                        System.out.println(entry.getKey() + ":" + entry.getValue());
                                    }
                                    System.out.println("------not contain channelid ----");
                                }


                            }

                        }

                    }

                }
            }
        } catch(IOException e){
        }
    }
}