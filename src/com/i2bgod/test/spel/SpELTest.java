package com.i2bgod.test.spel;

import org.junit.Test;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;
import java.util.Properties;

/**
 * @auther: Lyn
 * @data: 2018/9/30
 */
public class SpELTest {
    @Test
    public void testParserContext() {
        SpelExpressionParser parser = new SpelExpressionParser();
        ParserContext parserContext = new ParserContext() {
            @Override
            public boolean isTemplate() {
                return true;
            }

            @Override
            public String getExpressionPrefix() {
                return "#{";
            }

            @Override
            public String getExpressionSuffix() {
                return "}";
            }
        };

        String tpl = "#{'Hello'}#{'world'}";
        Expression expression = parser.parseExpression(tpl, parserContext);
        System.out.println(expression.getValue());
    }

    @Test
    public void testClassTypeExp() {
        SpelExpressionParser parser = new SpelExpressionParser();
        // java lang package
        Class<String> result = parser.parseExpression("T(String)").getValue(Class.class);
        System.out.println(result);

        // other package
        Class result2 = parser.parseExpression("T(com.i2bgod.test.service.impl.Hello)").getValue(Class.class);
        System.out.println(result2);
        // static field
        int result3 = parser.parseExpression("T(Integer).MAX_VALUE").getValue(int.class);
        System.out.println(result3);
        // static method
        Integer result4 = parser.parseExpression("T(Integer).parseInt('1')").getValue(int.class);
        System.out.println(result4);
    }

    @Test
    public void testConstructorExp() {
        SpelExpressionParser parser = new SpelExpressionParser();
        String value = parser.parseExpression("new String('haha')").getValue(String.class);
        System.out.println(value);

        Date value1 = parser.parseExpression("new java.util.Date()").getValue(Date.class);
        System.out.println(value1);

        // instanceof
        Boolean value2 = parser.parseExpression("'haha' instanceof T(String)").getValue(boolean.class);
        System.out.println(value2);
    }

    @Test
    public void testVarExp() {

        SpelExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("variable", "haha");
        String value = parser.parseExpression("#variable").getValue(context, String.class);
        System.out.println(value);


        context = new StandardEvaluationContext("haha");
        String value1 = parser.parseExpression("#root").getValue(context, String.class);
        System.out.println(value1);
        String value2 = parser.parseExpression("#this").getValue(context, String.class);
        System.out.println(value2);
    }

    @Test
    public void testBeanExpression() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.refresh();
        SpelExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new BeanFactoryResolver(ctx));
        Properties value = parser.parseExpression("@systemProperties").getValue(context, Properties.class);
        System.out.println(value);
    }

    @Test
    public void testPrefixExpression() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("el.xml");
        System.out.println(context.getBean("world"));
    }
}



