/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Procurador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dutan2000
 */
public class ControladorProcurador {
    private Procurador procurador;

    public ControladorProcurador() {
    }
    
        public void createProcurador(String cedula,String nombre,String apellido, Date fechaDeNacimiento,String direccion, String telefono){
        Connection con=ControladorBD.conection();
        procurador=new Procurador(cedula, nombre, apellido, fechaDeNacimiento, direccion, telefono);
        try {
            String sql="insert into procurador (cedula, nombre,apellido,fechadenacimiento,direccion,telefono) "
                    + "values (?,?,?,?,?,?)";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, procurador.getCedula());
            ps.setString(2, procurador.getNombre());
            ps.setString(3, procurador.getApellido());
            ps.setDate(4, new java.sql.Date(procurador.getFechaDeNacimiento().getTime()));
            ps.setString(5, procurador.getDireccion());
            ps.setString(6, procurador.getTelefono());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ControladorBD.disconect(con);
        }
    }
    
    public Procurador readProcurador(String cedula){
        Connection con=ControladorBD.conection();
        procurador=new Procurador(cedula, null, null, null, null, null);
        try {
            String sql="select * from procurador as p"
                    + "where p.cedula='"+ cedula+"'";
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet resultado= ps.executeQuery();
            procurador.setCedula(resultado.getString(1));
            procurador.setNombre(resultado.getString(2));
            procurador.setApellido(resultado.getString(3));
            procurador.setFechaDeNacimiento(new Date(resultado.getDate(4).getTime()));
            procurador.setDireccion(resultado.getString(5));
            procurador.setTelefono(resultado.getString(6));
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ControladorBD.disconect(con);
        }
       return procurador; 
    }
    
    
    public void updateProcurador(String cedula,String nombre,String apellido, Date fechaDeNacimiento,String direccion, String telefono){
        Connection con=ControladorBD.conection();
        procurador=new Procurador(cedula, nombre, apellido, fechaDeNacimiento, direccion, telefono);
        try {
            String sql="update procurador set nombre=?, apellido=?, fechadenacimiento=?, direccion=?,telefono=?"
                    + "where cedula=?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, procurador.getNombre());
            ps.setString(2, procurador.getApellido());
            ps.setDate(3, (java.sql.Date) procurador.getFechaDeNacimiento());
            ps.setString(4, procurador.getDireccion());
            ps.setString(5, procurador.getTelefono());
            ps.setString(6, procurador.getCedula());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ControladorBD.disconect(con);
        }
    }
    
    public void deleteProcurador(String cedula){
        Connection con=ControladorBD.conection();
        procurador=new Procurador(cedula, null, null, null, null, null);
        try {
            String sql="delete from procurador where cedula=?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, procurador.getCedula());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ControladorBD.disconect(con);
        }
    }
    
    public List<Procurador> findAll(){
       List<Procurador> procuradores=new ArrayList<>();
       Connection con=ControladorBD.conection();
        try {
            String sql="select * from procurador ";
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet resultado= ps.executeQuery();
            while(resultado.next()){
            procurador =new Procurador();
            procurador.setCedula(resultado.getString(1));
            procurador.setNombre(resultado.getString(2));
            procurador.setApellido(resultado.getString(3));
            procurador.setFechaDeNacimiento(new Date(resultado.getDate(4).getTime()));
            procurador.setDireccion(resultado.getString(5));
            procurador.setTelefono(resultado.getString(6));
            procuradores.add(procurador);
            }
        } catch (Exception e) {
        }
       return procuradores;
    }
}
