package com.lwl.data.scope.interceptor;

import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.lwl.data.scope.annotation.DataScope;
import com.lwl.data.scope.handler.IDataScopeHandler;
import com.lwl.data.scope.utils.SpringContextUtil;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Method;

/**
 * @description： 数据权限
 * @author     ：lwl
 * @date       ：2021/7/6 18:01
 * @version:     1.0.0
 */
public class DataScopeInterceptor implements InnerInterceptor {

    private static final String COUNT_PRE = "_COUNT";

    @Override
    public void beforeQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds,
                            ResultHandler resultHandler, BoundSql boundSql) {

        PluginUtils.MPBoundSql mpBs = PluginUtils.mpBoundSql(boundSql);
        String originalSql = boundSql.getSql();

        // 查找参数中包含DataScope类型的参数
        DataScope dataScope = getPermissionByDelegate(ms);
        if (dataScope != null &&   dataScope.handlerClass()!=null
                &&  IDataScopeHandler.class.isAssignableFrom(dataScope.handlerClass())) {
            IDataScopeHandler handler = (IDataScopeHandler) SpringContextUtil.getBean(dataScope.handlerClass());
            originalSql = handler.dataScopeFilter(originalSql,dataScope);
        }
        mpBs.sql(originalSql);
    }


    private DataScope getPermissionByDelegate(MappedStatement mappedStatement) {
        DataScope dataAuth = null;
        try {
            String id = mappedStatement.getId();
            //统计SQL取得注解也是实际查询id上得注解，所以需要去掉_COUNT
            if(id.contains(COUNT_PRE)){
                id = id.replace(COUNT_PRE,"");
            }
            String className = id.substring(0, id.lastIndexOf("."));
            String methodName = id.substring(id.lastIndexOf(".") + 1, id.length());
            final Class<?> cls = Class.forName(className);
            final Method[] method = cls.getMethods();
            for (Method me : method) {
                if (me.getName().equals(methodName) && me.isAnnotationPresent(DataScope.class)) {
                    dataAuth = me.getAnnotation(DataScope.class);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataAuth;
    }

}
