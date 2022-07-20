package kz.hustle;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@RestController
public class MainController {
    @GetMapping("/hello")
    public String index() {
        return "Good morning and welcome to the Black Mesa Transit System";
    }

    @GetMapping("/random-data")
    public Map<String,?> getSampleData(){
        Map<String, Object> map = new HashMap<>(); // use new HashMap<String, Object>(); for single result

        map.put("id", UUID.randomUUID());
        map.put("magic-number", (new Random()).nextInt());
        map.put("magic-text", generateRandomString());

        return map;
    }

    private String generateRandomString() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
}
