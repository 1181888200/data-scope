package com.lwl.data.scope.handler;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.lwl.data.scope.annotation.DataScope;
import com.lwl.data.scope.model.User;
import com.lwl.data.scope.type.ScopeType;
import com.lwl.data.scope.utils.LoginUser;
import org.springframework.stereotype.Component;

@Component
public class UserDataScopeHandler implements IDataScopeHandler {


    @Override
    public String dataScopeFilter(String originalSql, DataScope dataScopeAnno) {
        User user = LoginUser.getCurrent();
        String dataScope = user.getDataScope();

        String tableName = dataScopeAnno.tableName();

        originalSql = originalSql.toLowerCase().contains("where")?originalSql: originalSql +" where 1= 1";

        // 默认只查自己的
        originalSql += (String.format(" and ( %s.id = %s ", tableName, user.getId()));

        // 查询所有的数据
        if (ScopeType.DATA_SCOPE_ALL.equals(dataScope)) {
            originalSql += (" OR 1=1 ");
        }
        // 自定数据权限
        else if (ScopeType.DATA_SCOPE_CUSTOM.equals(dataScope))
        {
            // TODO
        }
        // 部门数据权限
        else if (ScopeType.DATA_SCOPE_DEPT.equals(dataScope))
        {
            originalSql += String.format(" OR %s.dept_id = %s ", tableName, user.getDeptId());

        }
        // 部门及以下数据权限
        else if (ScopeType.DATA_SCOPE_DEPT_AND_CHILD.equals(dataScope))
        {
            originalSql += (String.format(
                    " OR %s.dept_id IN ( SELECT id FROM t_dept WHERE dept_id = %s or find_in_set( %s , parent_id ) )",
                    tableName, user.getDeptId(), user.getDeptId()));
        }
        // 仅本人数据权限
        else if (ScopeType.DATA_SCOPE_SELF.equals(dataScope))
        {
            if (!StringUtils.isBlank(tableName))
            {
                originalSql += (String.format(" OR %s.id = %s ", tableName, user.getId()));
            }
            else
            {
                // 数据权限为仅本人且没有userAlias别名不查询任何数据
                originalSql += (" OR 1=0 ");
            }
        }
        originalSql +=")";
        return originalSql;
    }
}
