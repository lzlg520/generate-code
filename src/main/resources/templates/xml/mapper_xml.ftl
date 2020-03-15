<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${groupId}.${packageName}.mapper.${firstUpperName}Mapper">

    <select id="list" resultType="${groupId}.${packageName}.entity.${firstUpperName}">
        SELECT * FROM ${tableName}
    </select>

    <select id="get" parameterType="java.lang.${primaryKeyType}" resultType="${groupId}.${packageName}.entity.${firstUpperName}">
        SELECT * FROM ${tableName}
        WHERE ${primaryKey} = ${r'#{'}${primaryKey}${r'}'}
    </select>

    <insert id="add" parameterType="${groupId}.${packageName}.entity.${firstUpperName}" useGeneratedKeys="true">
        INSERT INTO ${tableName}
        (
        <#list columnModelList as column>
            <#if column.name != '${primaryKey}'>
                ${column.name}<#if column_has_next>,</#if>
            </#if>
        </#list>
        )
        VALUES
        (
        <#list columnModelList as column>
            <#if column.name != '${primaryKey}'>
                ${r'#{'}${column.camelCaseName}${r'}'}<#if column_has_next>,</#if>
            </#if>
        </#list>
        );
    </insert>

    <update id="update" parameterType="${groupId}.${packageName}.entity.${firstUpperName}">
        UPDATE ${tableName}
        <trim prefix="set" suffixOverrides=",">
            <#list columnModelList as column>
                <#if column.name != '${primaryKey}'>
                    <if test="${column.name} != null">${column.name} = ${r'#{'}${column.camelCaseName}${r'}'},</if>
                </#if>
            </#list>
        </trim>
        WHERE ${primaryKey} = ${r'#{'}${primaryKey}${r'}'}
    </update>

    <delete id="delete" parameterType="java.lang.${primaryKeyType}">
        DELETE FROM ${tableName}
        WHERE ${primaryKey} = ${r'#{'}${primaryKey}${r'}'}
    </delete>
</mapper>