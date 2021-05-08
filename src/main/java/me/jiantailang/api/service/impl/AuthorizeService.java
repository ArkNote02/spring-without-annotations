package me.jiantailang.api.service.impl;

import me.jiantailang.api.dao.Dao;
import me.jiantailang.api.entity.Entity;

public class AuthorizeService {

	private Dao dao;

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public void generate(String email, String password) {
		Entity entity = dao.read(email);

	}
}
