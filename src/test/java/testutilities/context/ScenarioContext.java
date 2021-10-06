package testutilities.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private Map<String, Object> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public void setContext(ContextEnum key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(ContextEnum key){
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(ContextEnum key){
        return scenarioContext.containsKey(key.toString());
    }
}
