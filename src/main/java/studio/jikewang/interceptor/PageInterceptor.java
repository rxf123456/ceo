package studio.jikewang.interceptor;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import studio.jikewang.util.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class PageInterceptor implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(
                statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY,
                SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        // 配置文件中SQL语句的ID
        String id = mappedStatement.getId();
        BoundSql boundSql = statementHandler.getBoundSql();
        // 原始的SQL语句
        String sql = boundSql.getSql();
//        System.out.println("未改造SQL语句" + sql);
        if (id.matches(".+list.+")) {
            System.out.println("启动Mybatis分页拦截器");
//            BoundSql boundSql = statementHandler.getBoundSql();
//            // 原始的SQL语句
//            String sql = boundSql.getSql();
            // 查询总条数的SQL语句
            String countSql = "select count(*) from (" + sql + ") a";
            Connection connection = (Connection) invocation.getArgs()[0];
            PreparedStatement countStatement = connection.prepareStatement(countSql);
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
            parameterHandler.setParameters(countStatement);
            ResultSet rs = countStatement.executeQuery();
            Page page = (Page) boundSql.getParameterObject();
            if (rs.next()) {
                init(page, rs.getInt(1));
            }
            // 改造后带分页查询的SQL语句
            String pageSql = sql + "ORDER BY " + page.getOrderType() + " " + page.getOrder() + " limit " + page.getOffset() + "," + page.getPageSize();
//            System.out.println("改造后带分页查询的SQL语句" + pageSql);
            metaObject.setValue("delegate.boundSql.sql", pageSql);
//            JsonUtil.prettyPrint(boundSql.getParameterObject());
        }
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
        System.out.println(properties.get("parameterInterceptor"));
    }

    public void init(Page page, int totalNumber) {

        page.setTotalNumber(totalNumber);
        // 计算总页数
        int totalPageTemp = page.getTotalNumber() / page.getPageSize();
        int plus = (page.getTotalNumber() % page.getPageSize()) == 0 ? 0 : 1;
        totalPageTemp = totalPageTemp + plus;
        if (totalPageTemp <= 0) {
            totalPageTemp = 1;
        }

        page.setTotalPage(totalPageTemp);

        // 设置当前页数

        // 总页数小于当前页数，应将当前页数设置为总页数
        if (page.getTotalPage() < page.getCurrentPage()) {
            page.setCurrentPage(page.getTotalPage());
        }

        // 当前页数小于1设置为1
        if (page.getCurrentPage() < 1) {
            page.setCurrentPage(1);
        }

        // 设置limit的参数
        page.setOffset((page.getCurrentPage() - 1) * page.getPageSize());

    }
}
