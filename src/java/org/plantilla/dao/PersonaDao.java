/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.plantilla.dao;

import java.util.List;
import org.plantilla.be.Persona;
import org.plantilla.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository("personaDao")
public class PersonaDao extends AbstractDA<Persona>{

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
        return list(Persona.class);
    }

    @Override
    public List<Persona> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Persona> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona buscar(long id) {
        return search(Persona.class, id);
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
        String hql = "from Persona a where a.nrodoc = '"+txtBusqueda+"'";
        return listar(hql);
    }

    public List<Persona> listarNombres(String txtBusqueda) {
    String hql = "from Persona a where a.socio like '%"+txtBusqueda+"%'";
        return listar(hql);    
    }

    public List<Persona> listarxIdPedido(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
