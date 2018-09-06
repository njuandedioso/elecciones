/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.plantilla.bl;

import java.util.List;
import org.plantilla.be.Persona;
import org.plantilla.dao.PersonaDao;
import org.plantilla.util.AbstractBL;
import org.plantilla.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("personaBl")
public class PersonaBl extends AbstractBL<Persona> {

    @Autowired
    @Qualifier("personaDao")
    private PersonaDao dao;

    @Override
    public AbstractDA getDAO() {
    return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long registrar(Persona bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long actualizar(Persona bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long eliminar(Persona bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Persona> listar() {
        return this.list();
    }

    @Override
    public List<Persona> listar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Persona> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona buscar(long id) {
        return search(id);
    }

    @Override
    public Persona buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Persona> listarRef(String txtBusqueda) {
        return dao.listarRef(txtBusqueda);
    }

    public List<Persona> listarNombres(String txtBusqueda) {
        return dao.listarNombres(txtBusqueda);
    }
    
    public List<Persona> listarxIdPedido(long id) {
        return dao.listarxIdPedido(id);
    }
}
