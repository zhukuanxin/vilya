package io.vilya.common.service;

import java.util.List;

import io.vilya.common.bean.req.QueryBean;

public interface BaseService<T> {

	T get(Integer id);

	List<T> list(QueryBean page, T record);

	void delete(Integer id);

	void save(T record);

	void update(T record);
}