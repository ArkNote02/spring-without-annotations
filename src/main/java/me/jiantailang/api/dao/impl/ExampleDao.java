package me.jiantailang.api.dao.impl;

import java.util.List;

import me.jiantailang.api.dao.Dao;
import me.jiantailang.api.entity.Entity;

public class ExampleDao implements Dao {

	@Override
	public int create(Entity entity) {
		throw new UnsupportedOperationException("create is not supported");
	}

	@Override
	public Entity read(int id) {
		throw new UnsupportedOperationException("read is not supported");
	}

	@Override
	public List<Entity> readAll() {
		throw new UnsupportedOperationException("readAll is not supported");
	}

	@Override
	public int edit(Entity entity) {
		throw new UnsupportedOperationException("edit is not supported");
	}

	@Override
	public int delete(int id) {
		throw new UnsupportedOperationException("delete is not supported");
	}
}
