package ${groupId}.${artifactId}.service;

import ${groupId}.${artifactId}.entity.${tableName};

import java.util.List;

public interface ${tableName}Service {

    List<${tableName}> list();

    ${tableName} get(int id);

    ${tableName} add(${tableName} ${tableName});

    ${tableName} update(${tableName} ${tableName});

    ${tableName} delete(int id);
}