package com.lwl.data.scope.handler;

import com.lwl.data.scope.annotation.DataScope;

public interface IDataScopeHandler {

    String dataScopeFilter(String originalSql, DataScope dataScopeAnno);

}
