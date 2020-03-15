package ${groupId}.${artifactId}.service.impl;

import ${groupId}.${artifactId}.entity.${firstUpperName};
import ${groupId}.${artifactId}.service.${firstUpperName}Service;
import ${groupId}.${artifactId}.mapper.${firstUpperName}Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Service
public class ${firstUpperName}ServiceImpl implements ${firstUpperName}Service {

    @Autowired
    ${firstUpperName}Mapper ${camelCaseName}Mapper;

    @Override
    public List<${firstUpperName}> list() {
        return ${camelCaseName}Mapper.list();
    }

    @Override
    public ${firstUpperName} get(int id) {
        return ${camelCaseName}Mapper.get(id);
    }

    @Override
    public ${firstUpperName} add(${firstUpperName} ${camelCaseName}) {
        ${camelCaseName}Mapper.add(${camelCaseName});
        return ${camelCaseName};
    }

    @Override
    public ${firstUpperName} update(int id, ${firstUpperName} ${camelCaseName}) {
        ${firstUpperName} old${firstUpperName} = get(id);
        if (old${firstUpperName} == null) {
            throw new RuntimeException("Can not get ${firstUpperName} by id");
        }
        BeanUtils.copyProperties(${camelCaseName}, old${firstUpperName});
        ${camelCaseName}Mapper.update(old${firstUpperName});
        return ${camelCaseName};
    }

    @Override
    public ${firstUpperName} delete(int id) {
        ${firstUpperName} ${camelCaseName} = get(id);
        if (${camelCaseName} == null) {
            throw new RuntimeException("Can not get ${firstUpperName} by id");
        }
        ${camelCaseName}Mapper.delete(id);
        return ${camelCaseName};
    }
}