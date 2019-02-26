package org.plantilla.ctrl;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.plantilla.be.Persona;
import org.plantilla.bl.PersonaBl;
import org.plantilla.ds.DSConeccion;
import org.plantilla.util.Variables;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class PersonaBean {

    @ManagedProperty(value = "#{personaBl}")
    private PersonaBl personaBl;
    @ManagedProperty(value = "#{persona}")
    private Persona persona;

    private String txtBusqueda;
    private String txtBusqueda1;
    
    private List<Persona> listPersonas;

    public PersonaBean() {
    }

    //@PostConstruct
    public void listar() {
        if (txtBusqueda!= null) {
            listarRef();
        }else{
            System.out.println("aquiii.... " + txtBusqueda);
        }
        
        //setListPersonas(personaBl.listar());
        
       
    }

    public void listarRef() {
        System.out.println("hola enter2..... " + txtBusqueda);
        setListPersonas(personaBl.listarRef(txtBusqueda.toLowerCase()));
    }

    public void listarNombres() {
        setListPersonas(personaBl.listarNombres(txtBusqueda1.toUpperCase()));
    }

//    
    public void onRowSelect(SelectEvent event) {
        //FacesMessage msg = new FacesMessage("Car Selected", ((Pedido)event.getObject()).getObservacion());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        //setListPedidoDetalle(personaBl.listarxIdPedido(((Persona) event.getObject()).getIdpersona()));
        setPersona(personaBl.buscar(((Persona) event.getObject()).getIdpersona()));
        System.out.println("perosna" + getPersona().getNroDoc());
    }

    // Visualizar reporte ticket
    public void visualizarTicket() {

        if (persona != null) {
            try {
                Map<String, Object> parametro = new HashMap<>();

                //File file = new File("C:\\Reportes\\REP-0005-nota-pedido.jasper");
                File file = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/WEB-INF/classes/org/plantilla/reportes/Ticket.jasper"));

                //DSConeccion ds = new DSConeccion("192.168.32.33", "5432", "sigadb_desa", "siga%admin", "siga%admin");
                DSConeccion ds = new DSConeccion(Variables.HOST, Variables.PORT, Variables.DB, Variables.USER, Variables.PASS);
                //RUTA LOGO
                //String path= getPath() + "/resources/img/logo.png";
                parametro.put("ID_PERSONA", persona.getIdpersona());
                //parametro.put("P_RUTAIMAGEN", path);
                byte[] documento = JasperRunManager.runReportToPdf(file.getPath(), parametro, ds.getConeccion());

                String fileType = "inline";
                String reportSetting = fileType + "; filename=Persona.pdf";

                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                response.setContentType("application/pdf");
                response.addHeader("Content-disposition", "inline; filename=Persona.pdf");
                response.setHeader("Cache-Control", "private");
                response.setContentLength(documento.length);

                ServletOutputStream stream = response.getOutputStream();
                stream.write(documento, 0, documento.length);
                stream.flush();
                stream.close();

                ds.getConeccion().close();

                FacesContext.getCurrentInstance().responseComplete();
            } catch (JRException ex) {
                Logger.getLogger(PersonaBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PersonaBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PersonaBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        //return "Reportes?faces-redirect=true";
    }

    // Visualizar reporte transeunte
    
    public void visualizarTranseunte() {

        if (persona != null) {
            try {
                Map<String, Object> parametro = new HashMap<>();

                //File file = new File("C:\\Reportes\\REP-0005-nota-pedido.jasper");
                File file = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/WEB-INF/classes/org/plantilla/reportes/Transeuntes.jasper"));

                //DSConeccion ds = new DSConeccion("192.168.32.33", "5432", "sigadb_desa", "siga%admin", "siga%admin");
                DSConeccion ds = new DSConeccion(Variables.HOST, Variables.PORT, Variables.DB, Variables.USER, Variables.PASS);
                //RUTA LOGO
                //String path= getPath() + "/resources/img/logo.png";
                parametro.put("ID_PERSONA", persona.getIdpersona());
                //parametro.put("P_RUTAIMAGEN", path);
                byte[] documento = JasperRunManager.runReportToPdf(file.getPath(), parametro, ds.getConeccion());

                String fileType = "inline";
                String reportSetting = fileType + "; filename=Persona.pdf";

                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                response.setContentType("application/pdf");
                response.addHeader("Content-disposition", "inline; filename=Persona.pdf");
                response.setHeader("Cache-Control", "private");
                response.setContentLength(documento.length);

                ServletOutputStream stream = response.getOutputStream();
                stream.write(documento, 0, documento.length);
                stream.flush();
                stream.close();

                ds.getConeccion().close();

                FacesContext.getCurrentInstance().responseComplete();
            } catch (JRException ex) {
                Logger.getLogger(PersonaBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PersonaBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PersonaBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        //return "Reportes?faces-redirect=true";
    }
    
    public void bucarPersona() {
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
    
    public String getTxtBusqueda1() {
        return txtBusqueda1;
    }

    public void setTxtBusqueda1(String txtBusqueda1) {
        this.txtBusqueda1 = txtBusqueda1;
    }

}
