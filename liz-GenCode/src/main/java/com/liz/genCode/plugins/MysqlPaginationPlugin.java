package com.liz.genCode.plugins;

import java.util.List;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * 基于MySql数据库的分页组件
 * Created by lizhou on 2016/7/21
 */
public class MysqlPaginationPlugin extends PluginAdapter {


//    @Override
//    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return super.sqlMapSelectByExampleWithBLOBsElementGenerated(element, introspectedTable);
//    }
//
//    @Override
//    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
//                                              IntrospectedTable introspectedTable) {
//        // add field, getter, setter for limit clause
//        addLimit(topLevelClass, introspectedTable, "limitStart");
//        addLimit(topLevelClass, introspectedTable, "limitEnd");
//        return super.modelExampleClassGenerated(topLevelClass,
//                introspectedTable);
//    }
//    @Override
//    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(
//            XmlElement element, IntrospectedTable introspectedTable) {
//        XmlElement isParameterPresenteElemen = (XmlElement) element
//                .getElements().get(element.getElements().size() - 1);
//        XmlElement isNotNullElement = new XmlElement("isGreaterEqual"); //$NON-NLS-1$
//        isNotNullElement.addAttribute(new Attribute("property", "limitStart")); //$NON-NLS-1$ //$NON-NLS-2$
//        isNotNullElement.addAttribute(new Attribute("compareValue", "0")); //$NON-NLS-1$ //$NON-NLS-2$
//        isNotNullElement.addElement(new TextElement(
//                "limit $limitStart$ , $limitEnd$"));
//        isParameterPresenteElemen.addElement(isNotNullElement);
//        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element,
//                introspectedTable);
//    }
//    private void addLimit(TopLevelClass topLevelClass,
//                          IntrospectedTable introspectedTable, String name) {
//        CommentGenerator commentGenerator = context.getCommentGenerator();
//        Field field = new Field();
//        field.setVisibility(JavaVisibility.PROTECTED);
//        field.setType(FullyQualifiedJavaType.getIntInstance());
//        field.setName(name);
//        field.setInitializationString("-1");
//        commentGenerator.addFieldComment(field, introspectedTable);
//        topLevelClass.addField(field);
//        char c = name.charAt(0);
//        String camel = Character.toUpperCase(c) + name.substring(1);
//        Method method = new Method();
//        method.setVisibility(JavaVisibility.PUBLIC);
//        method.setName("set" + camel);
//        method.addParameter(new Parameter(FullyQualifiedJavaType
//                .getIntInstance(), name));
//        method.addBodyLine("this." + name + "=" + name + ";");
//        commentGenerator.addGeneralMethodComment(method, introspectedTable);
//        topLevelClass.addMethod(method);
//        method = new Method();
//        method.setVisibility(JavaVisibility.PUBLIC);
//        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
//        method.setName("get" + camel);
//        method.addBodyLine("return " + name + ";");
//        commentGenerator.addGeneralMethodComment(method, introspectedTable);
//        topLevelClass.addMethod(method);
//    }
//    /**
//     * This plugin is always valid - no properties are required
//     */
//    public boolean validate(List<String> warnings) {
//        return true;
//    }


    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
                                              IntrospectedTable introspectedTable) { // add field, getter, setter
        // for limit clause
        addPage(topLevelClass, introspectedTable, "page");
        return super.modelExampleClassGenerated(topLevelClass,
                introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(
            XmlElement element, IntrospectedTable introspectedTable) {
        XmlElement page = new XmlElement("if");
        page.addAttribute(new Attribute("test", "page != null"));
        page.addElement(new TextElement("limit #{page.begin} , #{page.length}"));
        element.addElement(page);
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element,
                introspectedTable);
    }

    /**
     * @param topLevelClass
     * @param introspectedTable
     * @param name
     */
    private void addPage(TopLevelClass topLevelClass,
                         IntrospectedTable introspectedTable, String name) {
        topLevelClass.addImportedType(new FullyQualifiedJavaType(
                "com.liz.common.pojo.Pagination"));
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(new FullyQualifiedJavaType(
                "com.liz.common.pojo.Pagination"));
        field.setName(name);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(new FullyQualifiedJavaType(
                "com.liz.common.pojo.Pagination"), name));
        method.addBodyLine("this." + name + "=" + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType(
                "com.liz.common.pojo.Pagination"));
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }

    /**
     * This plugin is always valid - no properties are required
     */
    public boolean validate(List<String> warnings) {
        return true;
    }

}
