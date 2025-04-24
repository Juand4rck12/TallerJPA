/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Supplier;
import java.util.List;

/**
 * date: 24/04/2025
 * @author Esteban Colorado Vargas
 */
public interface ISupplierController {
    public void insert(Supplier supplier) throws Exception;
    public void update(Supplier supplier) throws Exception;
    public void delete(Supplier supplier) throws Exception;
    public Supplier findById(long id) throws Exception;
    public List<Supplier> findAll() throws Exception;
}
