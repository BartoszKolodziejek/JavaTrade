package strategy;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class StrategyRunner {


    public static final void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties properties = new Properties();
        properties.load(new FileReader(new File(args[0])));
        StrategyProperties.initilize(properties);
        Class stategyClass = Class.forName(properties.getProperty("strategyClass"));
        final Strategy strategy = (Strategy) stategyClass.newInstance();
        Thread stategyThread = new Thread() {
            @Override
            public void run() {
                strategy.run();
            }
        };
        stategyThread.start();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.next();
            if (command.equals("stop")){
                strategy.end = true;
                System.exit(0);
            }
        }

    }

}
