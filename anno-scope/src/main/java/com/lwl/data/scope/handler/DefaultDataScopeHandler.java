package com.lwl.data.scope.handler;

import com.lwl.data.scope.annotation.DataScope;
import org.springframework.stereotype.Component;

/**
 * @description： 默认处理，啥也不干
 * @author     ：lwl
 * @date       ：2021/7/6 10:43
 * @version:     1.0.0
 */
@Component
public class DefaultDataScopeHandler implements IDataScopeHandler {



    @Override
    public String dataScopeFilter(String originalSql, DataScope dataScopeAnno) {
        return originalSql;
    }
}
