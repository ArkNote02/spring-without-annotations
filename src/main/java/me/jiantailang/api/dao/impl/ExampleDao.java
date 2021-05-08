package me.jiantailang.api.dao.impl;

import java.util.List;

import me.jiantailang.api.dao.Dao;
import me.jiantailang.api.entity.Entity;

public class ExampleDao implements Dao {

	@Override
	public int create(Entity entity) {
		throw new UnsupportedOperationException("ExampleDao#create is not supported.");
	}

	@Override
	public Entity read(String id) {
		throw new UnsupportedOperationException("ExampleDao#read is not supported.");
	}

	@Override
	public List<Entity> readAll() {
		throw new UnsupportedOperationException("ExampleDao#readAll is not supported.");
	}

	@Override
	public int edit(Entity entity) {
		throw new UnsupportedOperationException("ExampleDao#edit is not supported.");
	}

	@Override
	public int delete(String id) {
		throw new UnsupportedOperationException("ExampleDao#delete is not supported.");
	}
}
