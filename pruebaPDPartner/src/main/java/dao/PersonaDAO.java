/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Persona;
import servicios.ConexionBD;

/**
 *
 * @author LuisLeon
 */
public class PersonaDAO {

    private Connection cn;

    public boolean crearPersona(Persona persona) throws SQLException, ClassNotFoundException {

        cn = ConexionBD.obtener();

        String sql = "insert into persona (nombres,apellidos,ciudad) values (?,?,?)";

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, persona.getNombres());
        ps.setString(2, persona.getApellidos());
        ps.setInt(3, persona.getCiudad());

        ps.execute();
        

        return true;
    }

    public boolean eliminarPersona(int id) throws SQLException, ClassNotFoundException {

        cn = ConexionBD.obtener();

        String sql = "delete from persona where id=?";

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, id);

        ps.execute();
        

        return true;
    }

    public List<Persona> getAllPersonas() throws SQLException, ClassNotFoundException {

        cn = ConexionBD.obtener();
        List<Persona> list = new ArrayList<>();
        String sql = "select * from persona";

        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Persona persona = new Persona();

            persona.setId(rs.getInt("ID"));
            persona.setNombres(rs.getString("NOMBRES"));
            persona.setApellidos(rs.getString("APELLIDOS"));
            persona.setCiudad(rs.getInt("CIUDAD"));

            list.add(persona);
        }
        

        return list;
    }

    public boolean editarPersona(Persona persona) throws SQLException, ClassNotFoundException {

        cn = ConexionBD.obtener();

        String sql = "update persona set nombres=?, apellidos=?, ciudad=? where id=?";

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, persona.getNombres());
        ps.setString(2, persona.getApellidos());
        ps.setInt(3, persona.getCiudad());
        ps.setInt(4, persona.getId());

        ps.execute();
        

        return true;
    }

}
