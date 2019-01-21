/*package com.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.entities.UserTest;

@Repository
@Transactional

public class UserDaoService {
	@PersistenceContext
	private EntityManager entityManager;

	public long insert(UserTest user) {
		entityManager.persist(user);
		return user.getId();
	}
}
*/