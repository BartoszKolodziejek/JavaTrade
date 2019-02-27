package strategy;

import java.util.Properties;

public class StrategyProperties {

    private static StrategyProperties strategyProperties;

    private Properties properties;

    static void initilize(Properties properties){
        strategyProperties = new StrategyProperties(properties);
    }

    public static StrategyProperties getInstance() {

        return strategyProperties;
    }

    private StrategyProperties(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties(){
        return properties;
    }

    public Object get(String key){
        return properties.get(key);
    }
}
