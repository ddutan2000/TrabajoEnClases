/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Asunto;
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
public class ControladorAsunto {

    private Asunto asunto;

    public ControladorAsunto() {
    }

    public void createAsunto(int numero, Date FechaDeInicio, Date fechaFinal, String estado, String cedulaCliente, String cedulaProcurador) {
        asunto = new Asunto(0, FechaDeInicio, fechaFinal, estado, cedulaCliente, cedulaProcurador);
        Connection con = ControladorBD.conection();
        try {
            String sql = "insert into asunto (numero, fecha_inicio,fecha_final,estado_tramite,cedula_cliente,cedula_procurador) "
                    + "values (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, asunto.getNumeroCaso());
            ps.setDate(2, new java.sql.Date(asunto.getFechaDeInicio().getTime()));
            ps.setDate(3, new java.sql.Date(asunto.getFechaFinal().getTime()));
            ps.setString(4, asunto.getEstado());
            ps.setString(5, asunto.getCedulaCliente());
            ps.setString(6, asunto.getCedulaProcurador());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ControladorBD.disconect(con);
        }

    }

    public void updateAsunto(int numero, String estado) {
        asunto = new Asunto(0, null, null, estado, null, null);
        Connection con = ControladorBD.conection();
        try {
            String sql = "update asunto set estado_tramite=?"
                    + "where numero=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, asunto.getEstado());
            ps.setInt(2, asunto.getNumeroCaso());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ControladorBD.disconect(con);
        }

    }

    public List<Asunto> findAll() {
        List<Asunto> asuntos = new ArrayList<>();
        Connection con = ControladorBD.conection();
        try {
            String sql = "select * from asunto ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                asunto = new Asunto();
                asunto.setNumeroCaso(resultado.getInt(1));
                asunto.setFechaDeInicio(resultado.getDate(2));
                asunto.setFechaFinal(resultado.getDate(3));
                asunto.setEstado(resultado.getString(4));
                asunto.setCedulaCliente(resultado.getString(5));
                asunto.setCedulaProcurador(resultado.getString(6));
                asuntos.add(asunto);
            }
        } catch (Exception e) {
        }
        return asuntos;
    }

}
