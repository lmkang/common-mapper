一、Mybatis通用Mapper(BaseMapper)
在springboot中使用
	a、引入jar包，放在本地Maven仓库
	
	b、注册和配置BaseMapperInterceptor
		可以使用xml方式和注解方式
		xml方式: 在spring配置文件的sqlSessionFactory中注入拦截器,
			然后在main方法中使用@ImportResource(locations = {"classpath:xxx"})引入xml
		<property name="plugins">
			<array>
				<bean class="org.wandaima.core.BaseMapperInterceptor">
					<!-- 固定名称 -->
					<property name="properties">
						<props>
							<!-- 关闭控制台输出 -->
							<prop key="common-mapper.debug">false</prop>
						</props>
					</properties>
				</bean>
			</array>
		</property>
		注解方式：@Configuration和@Bean。例如：
		@Configuration
		public Class MyConfiguration {
			@Bean
			public BaseMapperInterceptor baseMapperInterceptor() {
				BaseMapperInterceptor baseMapperInterceptor = new BaseMapperInterceptor();
				Properties props = new Properties();
				props.setProperty("common-mapper.debug", "false");// 关闭控制台输出
				baseMapperInterceptor.setProperties(props);
				return baseMapperInterceptor;
			}
		}
		注意: 注解和xml方式不能混用,否则会抛出空指针异常!!!
		在注册和配置BaseMapperInterceptor时可以指定参数,目前只有一个参数:common-mapper.debug,
		取值为 true/false(默认true): 打开控制台输出/关闭控制台输出,配置如上所述;
		
	c、在JavaBean的类上写上注解@Table(name = "对应的数据库表名称")
	
	d、创建Mapper接口(如UserMapper)继承BaseMapper，
		并创建xml文件(如：UserMapper.xml), 在里面配置好resultMap,
		其中, 至少有一个resultMap标签的id属性的值必须为BaseResultMap
		多表关联时:
			只支持多对一查询;
			<association>标签必填的属性: property, javaType, column, columnPrefix
		
	e、(已删除,不推荐使用)如果使用BaseService, 那么你的Service接口需要继承BaseService,
		Service实现需要继承BaseServiceImpl, 并且在你的service实现中写上, 例如:
		@BasisMapper
		@Autowired
		private UserMapper userMapper;
		
	f、自定义查询条件	(Criteria)
		(1)只支持AND查询;
		(2)orderBy("", ""): 第二个参数为"ASC"或者"DESC", 不区分大小写, 推荐大写
		
二、注意事项
1、一定要注册配置BaseMapperInterceptor,并且注解和xml方式不能混用,否则会抛出空指针异常!!!
2、xml中必须有一个<resultMap>标签的id为BaseResultMap;
3、查询: 只支持单表、多对一查询;
4、<association>标签必填的属性: property, javaType, column, columnPrefix;
5、自定义查询条件(Criteria)只支持AND查询;
6、除了update,其他操作的Criteria不能为null;
7、update: 如果Criteria为null, 则默认按照主键更新;
8、该插件不影响自定义的sql和mapper, 你可以写自己的sql和mapper, 但是方法名称不要和插件的几个方法名重复;
9、fieldList如果为null, 则默认查询所有字段(建议写上);
10、该插件适用范围: 
	(1)单表、多对一的增删改查;
	(2)只支持单一主键,并且外键关联也必须关联相应的单一主键;
	(3)自定义查询条件只支持AND;
	(4)只支持一层的多对一, 例如(不支持): A表(多)关联B表(一), B表(多)关联C表(一);