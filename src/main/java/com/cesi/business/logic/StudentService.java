package com.cesi.business.logic;

import com.cesi.business.domain.Student;
import jakarta.ejb.Remove;
import jakarta.ejb.Stateful;
import jakarta.inject.Inject;

import com.cesi.integration.StudentDAO;

@Stateful
public class StudentService implements  StudentServiceLocal{

    private Student student = new Student();

    @Inject
    StudentDAO studentDAO;

    /**
     * @param firstname
     * @param lastname
     */
    @Override
    public void addStudent(String firstname, String lastname) {
        student.setFirstname(firstname);
        student.setLastname(lastname);
        System.out.println("identité de l'etudiant "+firstname+" "+lastname);
    }

    /**
     * @param email
     * @param pwd
     */
    @Override
    public void addAuthenticationInformations(String email, String pwd) {
        student.setEmail(email);
        student.setPassword(pwd);
        System.out.println("ajout des informations d'authentification : "+email+" - "+pwd);
    }

    /**
     *
     */
    @Override
    @Remove
    public void save() {
        studentDAO.insert(student);
        System.out.println("sauvegarde de l'étudiant créé");
    }
}
