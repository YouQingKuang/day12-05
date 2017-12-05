package com.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.entity.User;

@Service
public class UserService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void addUser(User user) {
		entityManager.persist(user);
	}
	@Transactional
	public void updateUser(User user) {
		entityManager.createQuery("update User u set u.name=?1,u.pwd=?2,u.sex=?3 where u.id=?4")
		     .setParameter(1, user.getName())
		     .setParameter(2, user.getPwd())
		     .setParameter(3, user.getSex())
		     .setParameter(4, user.getId())
		     .executeUpdate();
	}
	@Transactional
	public User findUserById(int id) {
		User user = entityManager.find(User.class, id);
		return user;
	}
	@Transactional
	public List<User> findAllUser() {
		List<User> list = new ArrayList<>();
		list = entityManager.createQuery("select u from User u", User.class).getResultList();
		return list;
	}
	
}
