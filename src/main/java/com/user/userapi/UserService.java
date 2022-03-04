package com.user.userapi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("User_unit");
	EntityManager em = emf.createEntityManager();
	
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<User> cq = cb.createQuery(User.class);
	Root<User> root = cq.from(User.class);
	
	public List<User> getUsers(){
		List<User> userList = new ArrayList<>();
		userRepository.findAll().forEach(userList::add);
		return userList;
	}
	
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}
	
	public List<User> getUserByCity(String city) {
//		List<User> userList = new ArrayList<>();
		TypedQuery<User> query = em.createQuery(cq.select(root).where(cb.equal(root.get("city"), city)));
		return query.getResultList();
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
