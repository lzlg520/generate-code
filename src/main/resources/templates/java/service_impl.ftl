package ${groupId}.${artifactId}.service.impl;

import ${groupId}.${artifactId}.entity.${tableName};
import ${groupId}.${artifactId}.service.${tableName}Service;
import ${groupId}.${artifactId}.mapper.${tableName}Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Service
public class ${tableName}ServiceImpl implements ${tableName}Service {

    @Autowired
    ${tableName}Mapper ${tableName}Mapper;

    @Override
    public List<${tableName}> list() {
        return ${tableName}Mapper.list();
    }

    @Override
    public ${tableName} get(int id) {
        return ${tableName}Mapper.get(id);
    }

    @Override
    public ${tableName} add(${tableName} ${tableName}) {
        ${tableName}Mapper.add(${tableName});
        return ${tableName};
    }

    @Override
    public ${tableName} update(int id, ${tableName} ${tableName}) {
        ${tableName} old${tableName} = get(id);
        if (old${tableName} == null) {
            throw new RuntimeException("Can not get ${tableName} by id");
        }
        BeanUtils.copyProperties(${tableName}, old${tableName});
        ${tableName}Mapper.update(old${tableName});
        return ${tableName};
    }

    @Override
    public ${tableName} delete(int id) {
        ${tableName} ${tableName} = get(id);
        if (${tableName} == null) {
            throw new RuntimeException("Can not get ${tableName} by id");
        }
        ${tableName}Mapper.delete(id);
        return ${tableName};
    }
}