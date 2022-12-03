package cn.bravedawn.collection.list.copylist.converttojson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/29 13:21
 */
public class ConvertToJson {

    public static void main(String[] args) {
        Plant p1 = new Plant("杜鹃", "red", new Date());
        Plant p2 = new Plant("玫瑰", "yellow", new Date());
        Plant p3 = new Plant("月季", "pink", new Date());
        List<Plant> plantList = new ArrayList<>();
        plantList.add(p1);
        plantList.add(p2);
        plantList.add(p3);
        System.out.println("plants = " + plantList);

        Gson gson = new Gson();
        String jsonString = gson.toJson(plantList);

        List<Plant> plantsCopy = gson.fromJson(jsonString, plantList.getClass());
        System.out.println("plantsCopy = " + plantsCopy);
    }
}
