package Controller;

import Model.ConverterEngine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class CurrencyConverter {
    @GetMapping
    public String Converter() {
        return "index";
    }

    @PostMapping
    public ModelAndView Translate(@RequestParam("usd") String usd, @RequestParam("rate") String rate) {
        double amountUSD = Double.parseDouble(usd);
        double exchangeRate = Double.parseDouble(rate);
        double amountVND = ConverterEngine.ConvertUSDToVND(amountUSD, exchangeRate);
        ModelAndView model = new ModelAndView("converted");
        model.addObject("usd", amountUSD);
        model.addObject("vnd", amountVND);
        return model;
    }
}
