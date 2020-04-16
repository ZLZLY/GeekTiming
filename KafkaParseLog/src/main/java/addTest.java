import java.util.ArrayList;
import java.util.List;

public class addTest {
    public static void main(String[] args) {
        List<String> temp = new ArrayList();

        for(int i = 0 ; i<10; i++){
            if(i%2 == 0){
                temp.add("true");
            }else{
                temp.add("");
            }
        }
        String x = null;

        String id = "aaaaa\t"+null;
        x = id.split("\t")[1];
        System.out.println(x);
        if(x.equals(null) || x.length() == 0){
            System.out.println(x);
        }

//        System.out.println(id.split(":")[0]);
//        System.out.println(id.split(":")[1]);
//        System.out.println(getType(id.split(":")[1]));
//        if(id.split(":")[1].equals("null")){
//
//        }

    }
    public static String getType(Object o) { //获取变量类型方法
        return o.getClass().toString(); //使用int类型的getClass()方法
    }
}
