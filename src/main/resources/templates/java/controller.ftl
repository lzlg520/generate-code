package ${groupId}.${artifactId}.controller;

import org.springframework.web.bind.annotation.*;
import ${groupId}.${artifactId}.service.${tableName}Service;
import ${groupId}.${artifactId}.entity.${tableName};

import java.util.List;

@RestController
@RequestMapping("/${tableName}")
public class ${tableName}Controller {

    @Autowired
    ${tableName}Service ${tableName}Service;

    @GetMapping("/list")
    public List<${tableName}> list() {
        return ${tableName}Service.list();
    }

    @GetMapping("/get/{id}")
    public ${tableName} get(@PathVariable("id") int id) {
        return ${tableName}Service.get(id);
    }

    @PostMapping("/add")
    public ${tableName} add(@RequestBody ${tableName} ${tableName}) {
        return ${tableName}Service.add(${tableName});
    }

    @PutMapping("/update/{id}")
    public ${tableName} update(@PathVariable("id") int id, @RequestBody ${tableName} ${tableName}) {
        return ${tableName}Service.update(id, ${tableName});
    }

    @DeleteMapping("/delete/{id}")
    public ${tableName} delete(@PathVariable("id") int id) {
        return ${tableName}Service.delete(id);
    }
}