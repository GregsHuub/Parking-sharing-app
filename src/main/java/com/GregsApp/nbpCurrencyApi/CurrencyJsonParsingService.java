package com.GregsApp.nbpCurrencyApi;

import com.restfb.json.JsonArray;
import com.restfb.json.JsonObject;
import org.hibernate.type.descriptor.sql.SmallIntTypeDescriptor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Service
public class CurrencyJsonParsingService {

    public Double currencyValueFromNBP(String threeCharCurrency) throws IOException {

        String urlAddres = String.format("http://api.nbp.pl/api/exchangerates/rates/A/%s?format=json", threeCharCurrency);
        URL url = new URL(urlAddres);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();
        String jsonStr = "";

        if (responseCode != 200) throw new RuntimeException("HttpResponseCode: " + responseCode);
        else {
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                jsonStr += scanner.nextLine();
            }
            scanner.close();
        }
        double currencyValue = (double) 0;

        JSONObject obj = new JSONObject(jsonStr);
        JSONArray array = obj.getJSONArray("rates");
        int bound = array.length();
        for (int i = 0; i < bound; i++) {
            currencyValue = array.getJSONObject(i).getDouble("mid");
        }
        return currencyValue;
    }
}
