#DAO类：
countByExample  查询所有返回数量  
deleteByExample  删除所有  
deleteByPrimaryKey  根据id删除  
insert  添加数据  
insertSelective  添加数据（会进行判空）  
selectByExample  根据对应的Example类查询  
selectByPrimaryKey  根据id查询  
updateByExampleSelective  修改更新数据（会进行判空）  
updateByExampleSelective  修改更新数据  
updateByPrimaryKeySelective  根据id修改更新数据（会进行判空）  
updateByPrimaryKey  根据id修改更新数据  


#XXXKey类：
可以对id进行set/get  


#XXX类：
对除id进行set/get  


#XXXExample类：
protected String orderByClause    选择升降序（字段名+空格+asc/desc）  
* 使用：setOrderByClause("字段名 asc")  
* SQL: order by 字段名 asc  

protected boolean distinct    去除重复（true是选择不重复记录）  
* 使用：setDistinct(false)  

protected List<Criteria> oredCriteria    自定义条件查询（Criteria的集合）  

下面的NNN为字段名（属于条件：where）  
* andNNNIsNull  字段为空  
* andNNNIsNotNull  字段不为空  
* andNNNEqualTo  字段等于某值  
* andNNNNotEqualTo  字段不等于某值  
* andNNNGreaterThan  字段大于某值
* andNNNGreaterThanOrEqualTo  字段大于等于某值  
* andNNNLessThan  字段小于某值  
* andNNNLessThanOrEqualTo 字段小于等于某值  
* andNNNIn  字段等于多个值  
* andNNNNotIn  字段排除多个值  
* andNNNNBetween  字段包括（参数1）不包括（参数2）  
* andNNNNNotBetween  字段排除包括（参数1）不包括（参数2）  
* andNNNLike  字段模糊查询  
* andNNNNotLike  字段排除模糊查询  
