package learn.weatherapp.Service;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String apiKey = "34cf6b80a91066cf7a305bbe9c5ca284";
    private static final String weatherApi = "https://api.weatherstack.com/current?access_key=API_Key&query=city";

    public Map<String,Object> ReturnWeather(String City){

        
       String finalAPi= weatherApi.replace("city",City).replace("API_Key",apiKey);
        
        ResponseEntity<Map> response= restTemplate.exchange(finalAPi,HttpMethod.GET,null,Map.class);
        return response.getBody();
    }

}