/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.app.services;

import java.util.List;

/**
 *
 * @author mak
 */
public interface ProjectRepository<T> {
    List<T> retriveAll();
    void store(T book);
}
