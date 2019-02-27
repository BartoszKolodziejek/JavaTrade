package orders;


import com.google.gson.Gson;
import exception.SendingException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import strategy.StrategyProperties;
import trade.Trade;

import java.io.IOException;

public class OrderManager {
    private static OrderManager ourInstance = new OrderManager();
    private HttpClient httpClient= HttpClientBuilder.create().build();
    private Gson gson = new Gson();

    public static OrderManager getInstance() {
        return ourInstance;
    }

    private OrderManager() {
    }

    public void makeOrder(Order order) throws IOException {
        HttpPost httpPost = new HttpPost(StrategyProperties.getInstance().get("endpoint")+"/order/make");
        StringEntity params = new StringEntity("order="+gson.toJson(order));
        httpPost.addHeader("content-type", "application/x-www-form-urlencoded");
        httpPost.setEntity(params);
        HttpResponse response = httpClient.execute(httpPost);
    }




}
