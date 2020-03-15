package ${groupId}.${packageName}.service;

import ${groupId}.${packageName}.entity.${firstUpperName};

import java.util.List;

public interface ${firstUpperName}Service {

    List<${firstUpperName}> list();

    ${firstUpperName} get(${primaryKeyType} ${primaryKey});

    ${firstUpperName} add(${firstUpperName} ${camelCaseName});

    ${firstUpperName} update(${primaryKeyType} ${primaryKey}, ${firstUpperName} ${camelCaseName});

    ${firstUpperName} delete(${primaryKeyType} ${primaryKey});
}