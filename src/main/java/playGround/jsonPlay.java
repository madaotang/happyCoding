package playGround;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class jsonPlay {


    public static Task parseStringToTask(String json){
        JSONObject taskJson = JSON.parseObject(json);
        List<String> vins = (List<String>) taskJson.get("vins");
        String userId = taskJson.getString("userId");

        List<SignalFilter> filters = new LinkedList<SignalFilter>();

        JSONArray filtersJSON = taskJson.getJSONArray("filters");

        for (Object filterObj: filtersJSON
             ) {
            JSONObject filterJSON = (JSONObject) filterObj;
            SignalFilter filter = new SignalFilter(filterJSON.getString("flagIndex"),filterJSON.getString("conditions"));
            filters.add(filter);
        }

        return new Task(vins,userId,filters);
    }

}

class SignalFilter{
    private String flagIndex;
    private String conditions;

    public SignalFilter(String flagIndex, String conditions) {
        this.flagIndex = flagIndex;
        this.conditions = conditions;
    }

    public String getFlagIndex() {
        return flagIndex;
    }

    public void setFlagIndex(String flagIndex) {
        this.flagIndex = flagIndex;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "SignalFilter{" +
                "flagIndex='" + flagIndex + '\'' +
                ", conditions='" + conditions + '\'' +
                '}';
    }
}

class Task{
    private List<String> vins;
    private String userId;
    private List<SignalFilter> filters;

    public Task(List<String> vins, String userId, List<SignalFilter> filters) {
        this.vins = vins;
        this.userId = userId;
        this.filters = filters;
    }

    public List<String> getVins() {
        return vins;
    }

    public void setVins(List<String> vins) {
        this.vins = vins;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<SignalFilter> getFilters() {
        return filters;
    }

    public void setFilters(List<SignalFilter> filters) {
        this.filters = filters;
    }
}