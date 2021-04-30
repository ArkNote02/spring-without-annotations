package me.jiantailang.api.service.impl;

import me.jiantailang.api.dao.Dao;
import me.jiantailang.api.entity.Entity;
import me.jiantailang.api.service.Service;

public class ExampleService implements Service {

	private Dao dao;

	@Override
	public void serve() {
		dao.create(new Entity() {});
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}
}
