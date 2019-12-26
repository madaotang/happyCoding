package playGround;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static playGround.jsonPlay.parseStringToTask;

public class jsonPlayTest {

    @Test
    public void parseStringToTaskTest(){
            List<SignalFilter> signalFilters = new LinkedList<SignalFilter>();
            signalFilters.add(new SignalFilter("1_1",">3"));
            signalFilters.add(new SignalFilter("2_2","==3"));

            List<String> vins = new LinkedList<String>();
            vins.add("12312313123");
            vins.add("123123123123123123123123");

            Task task = new Task(vins,"me",signalFilters);

            System.out.println(JSON.toJSONString(task));

            String json = JSON.toJSONString(task);

            System.out.println(JSON.toJSONString(parseStringToTask(json)));

            assertEquals(JSON.toJSONString(parseStringToTask(json)),json);

    }

}