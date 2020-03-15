package ${groupId}.${artifactId}.service;

import ${groupId}.${artifactId}.entity.${firstUpperName};

import java.util.List;

public interface ${firstUpperName}Service {

    List<${firstUpperName}> list();

    ${firstUpperName} get(int id);

    ${firstUpperName} add(${firstUpperName} ${camelCaseName});

    ${firstUpperName} update(${firstUpperName} ${camelCaseName});

    ${firstUpperName} delete(int id);
}