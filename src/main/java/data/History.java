package data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class History {

    private final List<Candle> history = new ArrayList<>();

    private static History historyInstance = new History();

    private History(){

    }

    public static History getHistoryInstance() {
        return historyInstance;
    }

    public void addToHistory(Candle candle){
        history.add(candle);
        history.remove(0);
    }

    public void load (List<Candle> candles){
        history.addAll(candles
                .parallelStream()
                .sorted(Comparator.comparing(Candle::getDate).reversed())
                .collect(Collectors.toList()));
    }

    public List<Candle> getLast(int last){
        return history.subList(history.size()-last-1, history.size()-1)
                .parallelStream()
                .sorted(Comparator.comparing(Candle::getDate))
                .collect(Collectors.toList());
    }
}
