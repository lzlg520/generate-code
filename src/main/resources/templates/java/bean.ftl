package ${packageName}.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("${requestPath}")
public class GenerateCodeController {

    @GetMapping("/do")
    public void generateCode() {

    }
}