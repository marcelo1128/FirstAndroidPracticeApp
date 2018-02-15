package test.restful;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by MarceloMaldonado on 2/13/2018.
 */

public class restfulConsumerHandler extends AsyncTask<Void, Void, countriesTemplateRestful> {

    @Override
    protected countriesTemplateRestful doInBackground(Void... params) {
        try {
            final String url = "http://services.groupkt.com/state/get/USA/all"; // the  url from where to fetch data(json)
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            countriesTemplateRestful info = restTemplate.getForObject(url,
                    countriesTemplateRestful.class);

            return info;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(countriesTemplateRestful info) {
        Log.i("MainActivity", info.toString());
    }


}
