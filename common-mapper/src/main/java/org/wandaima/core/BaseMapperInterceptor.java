package org.wandaima.core;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts({
	@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
	@Signature(type = Executor.class, method = "query", args = { 
		MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class
	})
})
public class BaseMapperInterceptor implements Interceptor {

	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		if(args != null && args.length > 0) {
			MappedStatement mappedStmt = (MappedStatement) args[0];
			if(mappedStmt != null) {
				BaseSqlProvider.setMappedStmt(mappedStmt);
			}
		}
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		if(properties != null) {
			BaseSqlProvider.setProperties(properties);
		}
	}

}
