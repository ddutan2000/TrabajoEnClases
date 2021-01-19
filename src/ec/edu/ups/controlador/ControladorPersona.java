/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Cliente;
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
public class ControladorPersona {
    private Cliente cliente;

    public ControladorPersona() {
    }
    
    public void createCliente(String cedula,String nombre,String apellido, Date fechaDeNacimiento,String direccion, String telefono){
        Connection con=ControladorBD.conection();
        cliente=new Cliente(cedula, nombre, apellido, fechaDeNacimiento, direccion, telefono);
        try {
            String sql="insert into cliente (cedula, nombre,apellido,fechadenacimiento,direccion,telefono) "
                    + "values (?,?,?,?,?,?)";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, cliente.getCedula());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setDate(4, new java.sql.Date(cliente.getFechaDeNacimiento().getTime()));
            ps.setString(5, cliente.getDireccion());
            ps.setString(6, cliente.getTelefono());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ControladorBD.disconect(con);
        }
    }
    
    public Cliente readCliente(String cedula){
        Connection con=ControladorBD.conection();
        cliente=new Cliente(cedula, null, null, null, null, null);
        try {
            String sql="select * from cliente as c"
                    + "where c.cedula='"+ cedula+"'";
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet resultado= ps.executeQuery();
            cliente.setCedula(resultado.getString(1));
            cliente.setNombre(resultado.getString(2));
            cliente.setApellido(resultado.getString(3));
            cliente.setFechaDeNacimiento(new Date(resultado.getDate(4).getTime()));
            cliente.setDireccion(resultado.getString(5));
            cliente.setTelefono(resultado.getString(6));
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ControladorBD.disconect(con);
        }
       return cliente; 
    }
    
    
    public void updateCliente(String cedula,String nombre,String apellido, Date fechaDeNacimiento,String direccion, String telefono){
        Connection con=ControladorBD.conection();
        cliente=new Cliente(cedula, nombre, apellido, fechaDeNacimiento, direccion, telefono);
        try {
            String sql="update cliente set nombre=?, apellido=?, fechadenacimiento=?, direccion=?,telefono=?"
                    + "where cedula=?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setDate(3, (java.sql.Date) cliente.getFechaDeNacimiento());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getCedula());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ControladorBD.disconect(con);
        }
    }
    
    public void deleteCliente(String cedula){
        Connection con=ControladorBD.conection();
        cliente=new Cliente(cedula, null, null, null, null, null);
        try {
            String sql="delete from cliente where cedula=?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, cliente.getCedula());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ControladorBD.disconect(con);
        }
    }
    
    public List<Cliente> findAll(){
       List<Cliente> clientes=new ArrayList<>();
       Connection con=ControladorBD.conection();
        try {
            String sql="select * from cliente";
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet resultado= ps.executeQuery();
            while(resultado.next()){
            cliente =new Cliente();
            cliente.setCedula(resultado.getString(1));
            cliente.setNombre(resultado.getString(2));
            cliente.setApellido(resultado.getString(3));
            cliente.setFechaDeNacimiento(new Date(resultado.getDate(4).getTime()));
            cliente.setDireccion(resultado.getString(5));
            cliente.setTelefono(resultado.getString(6));
            clientes.add(cliente);
            }
        } catch (Exception e) {
        }
       return clientes;
    }
    
}
