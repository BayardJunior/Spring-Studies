package brincando.spring5.bbbms.controller;

import brincando.spring5.bbbms.service.DemoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("demo")
    public String demo(Model model) {
        model.addAttribute("message", demoService.getMessage());
        return "demo/demo";
    }
}
