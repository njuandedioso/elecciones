package org.plantilla.ctrl;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.plantilla.be.Persona;
import org.plantilla.bl.PersonaBl;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class PersonaBean {

    @ManagedProperty(value = "#{personaBl}")
    private PersonaBl personaBl;
    @ManagedProperty(value = "#{familia}")
    private Persona persona;

    private String txtBusqueda;
    private List<Persona> listPersonas;
    
    public PersonaBean() {
    }
    
    @PostConstruct
    public void listar(){
        setListPersonas(personaBl.listar());
    }
    
    public void listarRef(){
        System.out.println("hola"+txtBusqueda);
        setListPersonas(personaBl.listarRef(txtBusqueda.toLowerCase()));
    }
       
    public void listarNombres(){
        setListPersonas(personaBl.listarNombres(txtBusqueda.toUpperCase()));
    }
          
//    
    public void onRowSelect(SelectEvent event) {
        //FacesMessage msg = new FacesMessage("Car Selected", ((Pedido)event.getObject()).getObservacion());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        //setListPedidoDetalle(personaBl.listarxIdPedido(((Persona) event.getObject()).getIdpersona()));
        setPersona(personaBl.buscar(((Persona)event.getObject()).getIdpersona()));
        System.out.println("perosna"+getPersona().getNrodoc());
    }
    
    public void bucarPersona(){
        System.out.println("...");
    }
    
    
    public PersonaBl getPersonaBl() {
        return personaBl;
    }

    public void setPersonaBl(PersonaBl personaBl) {
        this.personaBl = personaBl;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }
    
    public String getTxtBusqueda() {
        return txtBusqueda;
    }

    public void setTxtBusqueda(String txtBusqueda) {
        this.txtBusqueda = txtBusqueda;
    }
   
}
