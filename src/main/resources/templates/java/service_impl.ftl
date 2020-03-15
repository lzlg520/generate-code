package ${groupId}.${packageName}.service.impl;

import ${groupId}.${packageName}.entity.${firstUpperName};
import ${groupId}.${packageName}.service.${firstUpperName}Service;
import ${groupId}.${packageName}.mapper.${firstUpperName}Mapper;
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
    public ${firstUpperName} get(${primaryKeyType} ${primaryKey}) {
        return ${camelCaseName}Mapper.get(${primaryKey});
    }

    @Override
    public ${firstUpperName} add(${firstUpperName} ${camelCaseName}) {
        ${camelCaseName}Mapper.add(${camelCaseName});
        return ${camelCaseName};
    }

    @Override
    public ${firstUpperName} update(${primaryKeyType} ${primaryKey}, ${firstUpperName} ${camelCaseName}) {
        ${firstUpperName} old${firstUpperName} = get(${primaryKey});
        if (old${firstUpperName} == null) {
            throw new RuntimeException("Can not get ${firstUpperName} by ${primaryKey}");
        }
        BeanUtils.copyProperties(${camelCaseName}, old${firstUpperName});
        ${camelCaseName}Mapper.update(old${firstUpperName});
        return ${camelCaseName};
    }

    @Override
    public ${firstUpperName} delete(${primaryKeyType} ${primaryKey}) {
        ${firstUpperName} ${camelCaseName} = get(${primaryKey});
        if (${camelCaseName} == null) {
            throw new RuntimeException("Can not get ${firstUpperName} by ${primaryKey}");
        }
        ${camelCaseName}Mapper.delete(${primaryKey});
        return ${camelCaseName};
    }
}