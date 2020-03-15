package ${groupId}.${artifactId}.controller;

import org.springframework.web.bind.annotation.*;
import ${groupId}.${artifactId}.service.${firstUpperName}Service;
import ${groupId}.${artifactId}.entity.${firstUpperName};

import java.util.List;

@RestController
@RequestMapping("/${path}")
public class ${firstUpperName}Controller {

    @Autowired
    ${firstUpperName}Service ${camelCaseName}Service;

    @GetMapping("/list")
    public List<${firstUpperName}> list() {
        return ${camelCaseName}Service.list();
    }

    @GetMapping("/get/{id}")
    public ${firstUpperName} get(@PathVariable("id") int id) {
        return ${camelCaseName}Service.get(id);
    }

    @PostMapping("/add")
    public ${firstUpperName} add(@RequestBody ${firstUpperName} ${camelCaseName}) {
        return ${camelCaseName}Service.add(${camelCaseName});
    }

    @PutMapping("/update/{id}")
    public ${firstUpperName} update(@PathVariable("id") int id, @RequestBody ${firstUpperName} ${camelCaseName}) {
        return ${camelCaseName}Service.update(id, ${camelCaseName});
    }

    @DeleteMapping("/delete/{id}")
    public ${firstUpperName} delete(@PathVariable("id") int id) {
        return ${camelCaseName}Service.delete(id);
    }
}