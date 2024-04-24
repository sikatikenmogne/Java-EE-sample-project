package com.cesi.integration;
import com.cesi.business.domain.Student;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class StudentDAO {
    @PersistenceContext(unitName = "bigAppPU")
    private EntityManager em;

    public void insert(Student student) {
        em.persist(student);
        em.flush();
    }
}
