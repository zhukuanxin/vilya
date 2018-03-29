package io.vilya.common.service;

import java.util.List;

import com.github.pagehelper.PageHelper;

import io.vilya.common.bean.EntityBean;
import io.vilya.common.bean.req.QueryBean;
import io.vilya.common.mapper.BaseMapper;

public abstract class AbstractService<T extends EntityBean> implements BaseService<T> {

    public T get(Integer id) {
        return getMapper().get(id);
    }

    public List<T> list(QueryBean pageBean, T record) {
        if (pageBean != null && pageBean.getCurrentPage() != null && pageBean.getPageSize() != null) {
            PageHelper.startPage(pageBean.getCurrentPage(), pageBean.getPageSize());
        }
        return getMapper().list(record);
    }

    public void delete(Integer id) {
        getMapper().delete(id);
    }

    public void save(T record) {
        getMapper().save(record);
    }

    public void update(T record) {
        getMapper().update(record);
    }

    protected abstract BaseMapper<T> getMapper();
}