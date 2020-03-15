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

    @GetMapping("/get/{${primaryKey}}")
    public ${firstUpperName} get(@PathVariable("${primaryKey}") ${primaryKeyType} ${primaryKey}) {
        return ${camelCaseName}Service.get(id);
    }

    @PostMapping("/add")
    public ${firstUpperName} add(@RequestBody ${firstUpperName} ${camelCaseName}) {
        return ${camelCaseName}Service.add(${camelCaseName});
    }

    @PutMapping("/update/{${primaryKey}}")
    public ${firstUpperName} update(@PathVariable("${primaryKey}") ${primaryKeyType} ${primaryKey}, @RequestBody ${firstUpperName} ${camelCaseName}) {
        return ${camelCaseName}Service.update(${primaryKey}, ${camelCaseName});
    }

    @DeleteMapping("/delete/{${primaryKey}}")
    public ${firstUpperName} delete(@PathVariable("${primaryKey}") ${primaryKeyType} ${primaryKey}) {
        return ${camelCaseName}Service.delete(${primaryKey});
    }
}