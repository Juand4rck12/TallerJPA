/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Person;
import java.util.List;

/**
 * date: 24/04/2025
 * @author Esteban Colorado Vargas
 */
public interface IPersonController {
    public void insert(Person person) throws Exception;
    public void update(Person person) throws Exception;
    public void delete(Person person) throws Exception;
    public Person findById(long id) throws Exception;
    public List<Person> findAll() throws Exception;
}
