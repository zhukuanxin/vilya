package io.vilya.common.mapper;

import java.util.List;

import io.vilya.common.bean.EntityBean;

public interface BaseMapper<T extends EntityBean> {
    T get(Integer id);

    List<T> list(T record);

    int delete(Integer id);

    int save(T record);

    int update(T record);
}