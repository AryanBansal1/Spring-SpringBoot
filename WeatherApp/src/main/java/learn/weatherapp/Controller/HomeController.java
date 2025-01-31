package learn.weatherapp.Controller;

import org.springframework.web.bind.annotation.RestController;

import learn.weatherapp.Service.WeatherService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HomeController {

    @Autowired
    WeatherService weatherService ;   

    @GetMapping("/")
    public ResponseEntity<?> Welcome() {
      Map<String,Object> WeatherResponse = weatherService.ReturnWeather("Delhi");
      Map<String,Object> current = (Map<String,Object>) WeatherResponse.get("current");
      String temperature = current.get("temperature").toString();
       return ResponseEntity.ok("the weather feels like "+ temperature+ "°C");
    }
    
}
