# data-scope
    数据权限校验：springboot + Mybatis-plus + MySQL 自定义注解实现数据权限校验。
    
    **使用方法**：通过自定义注解方式，在执行SQL语句的前面拦截执行语句，通过判断该方法是否有注解DataScope对象，
    如果存在，则执行DataScope中的对应类的handlerClass()的方法，用户可自定义IDataScopeHandler的实现类，
    这样可针对不同的SQL，执行不同的操作逻辑，实现定制化需求。


# 数据权限关系图
    ![image](https://github.com/1181888200/data-scope/blob/main/doc/%E6%9D%83%E9%99%90%E5%85%B3%E7%B3%BB%E5%9B%BE.png)

# 权限说明
    页面权限：就是用户能看到什么页面
    
    数据权限：同一个页面下，不同用户可以看到什么数据
    
    操作权限：相同数据不能用户能对其进行什么操作（一般分为：查看、编辑和完全控制）
