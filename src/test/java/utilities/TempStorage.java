package utilities;

import java.util.HashMap;
import java.util.Map;

public class TempStorage {

    private static Map<String ,String > values = new HashMap<>();


    public static void  addValue(String key,String value){
        values.put(key,value);
    }

    public static  String getValue(String key){
        return values.get(key);
    }
}
