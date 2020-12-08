package com.nov.virtual.test;


import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public  abstract class BaseService<T> {
    @Autowired
    private BaseMapper<T> mapper;

    /**
     * 保存
     *
     */
    public Integer save(T entity) {
        return this.mapper.insert(entity);
    }

    /**
     * 选择性保存:null的属性不会保存，使用数据库默认值
     */
    public Integer savec(T entity) {
        return this.mapper.insertSelective(entity);
    }

    /**
     * 批量保存
     */
    public Integer save(List<T> entityList) {
        return mapper.insertList(entityList);
    }

    /**
     * 删除
     *
     */
    public Integer delete(String id) {

        return this.mapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    public Integer delete(List<String> ids) {
        Class<T> Tclass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Example example=new Example(Tclass);
        Example.Criteria criteria=example.createCriteria();
        criteria.andIn("id", ids);
        return this.mapper.deleteByExample(example);
    }

    /**
     * 更新
     *
     */
    public Integer update(T entity) {
        return this.mapper.updateByPrimaryKey(entity);
    }

    /**
     * 更新:属性不为null的值
     *
     */
    public Integer updatec(T entity) {
        return this.mapper.updateByPrimaryKeySelective(entity);
    }

    /**
     * 通过id查询
     */
    public T findById(String id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询全部
     *
     */
    public List<T> findAll() {
        return this.mapper.selectAll();
    }
}
