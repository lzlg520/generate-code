<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${groupId}.${artifactId}.mapper.${firstUpperName}Mapper">

    <select id="list" resultType="${groupId}.${artifactId}.entity.${firstUpperName}">
        SELECT * FROM ${tableName}
    </select>

    <select id="get" parameterType="java.lang.Integer" resultType="${groupId}.${artifactId}.entity.${firstUpperName}">
        SELECT * FROM ${tableName}
        WHERE id = ${r'#{id}'}
    </select>

    <insert id="add" parameterType="${groupId}.${artifactId}.entity.${firstUpperName}" useGeneratedKeys="true">
        INSERT INTO ${tableName}
        (
        <#list columnModelList as column>
            <#if column.name != 'id'>
                ${column.name}<#if column_has_next>,</#if>
            </#if>
        </#list>
        )
        VALUES
        (
        <#list columnModelList as column>
            <#if column.name != 'id'>
                ${r'#{column.name}'}<#if column_has_next>,</#if>
            </#if>
        </#list>
        );
    </insert>

    <update id="update" parameterType="${groupId}.${artifactId}.entity.${firstUpperName}">
        UPDATE ${tableName}
        <trim prefix="set" suffixOverrides=",">
            <#list columnModelList as column>
                <#if column.name != 'id'>
                    <if test="${column.name} != null">${column.name} = ${r'#{column.name}'},</if>
                </#if>
            </#list>
        </trim>
        WHERE id = ${r'#{tableName.id}'}
    </update>

    <delete id="delete" parameterType="java.lang.Integer">
        DELETE FROM ${tableName}
        WHERE id = ${r'#{id}'}
    </delete>
</mapper>