import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.io.*;


public class livlogTest {
    public static void main(String[] args) throws Exception {
            BufferedReader in = new BufferedReader(new FileReader("D:\\WeiObjects\\showdata\\src\\main\\resources\\20200315_14.text"));
            String str;
            while ((str = in.readLine()) != null) {
                JSONObject logJson = JSONObject.parseObject(str)
                        .getJSONObject("data")
                        .getJSONObject("data")
                        .getJSONObject("log");
                System.out.println(logJson);

            }


    }
}