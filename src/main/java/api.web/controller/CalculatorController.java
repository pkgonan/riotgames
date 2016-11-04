package api.web.controller;

import api.web.domain.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {
    @Autowired
    private CalculationService calculationService;

    @CrossOrigin(origins = "http://coding.recruit.leagueoflegends.co.kr:8080")
    @RequestMapping(value = "calculate", method = RequestMethod.POST)
    public @ResponseBody String insertDataMap(@RequestBody MultiValueMap<String, String> body) {
        String calculationResult = calculationService.calculate(body.keySet().toString().replace("[", "").replace("]", ""));

        return calculationResult;
    }
}