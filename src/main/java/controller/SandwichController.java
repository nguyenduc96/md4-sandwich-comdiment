package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @GetMapping
    public String show(){
        return "index";
    }

    @GetMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment, Model model) {
        if (condiment == null) {
            model.addAttribute("message", "Choice sandwich");
        } else {
            String spices = "";
            StringBuilder stringBuilder = new StringBuilder(spices);
            for(String s : condiment) {
                if (condiment.length == 1) {
                    stringBuilder.append(s);
                } else {
                    stringBuilder.append(s).append(" - ");
                }
            }
            model.addAttribute("spices",stringBuilder);
        }
        return "index";
    }
}
