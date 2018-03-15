/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import model.MyBatisUtils;
import model.pojos.Contacto;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Daniela
 * @since 09/03/2018
 * @version 1.0
 */

public class ContactoDAO {

    public static List<Contacto> getAllContactos() {
        List<Contacto> lista = new ArrayList<Contacto>();
        SqlSession conn = null;
        try {
            conn = MyBatisUtils.getSession();
            lista = conn.selectList("Contacto.getAllContactos");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return lista;
    }

    public static List<Contacto> buscarContacto(String nombre) {
        List<Contacto> lista = new ArrayList<Contacto>();
        SqlSession conn = null;
        try {
            conn = MyBatisUtils.getSession();
            lista = conn.selectList("Contacto.buscarContacto", nombre);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return lista;
    }

    public static boolean registrar(Contacto c) {
        SqlSession conn = null;
        try {
            conn = MyBatisUtils.getSession();
            conn.insert("Contacto.registrar", c);
            conn.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public static boolean actualizar(Contacto c) {
        SqlSession conn = null;
        try {
            conn = MyBatisUtils.getSession();
            conn.update("Contacto.actualizar", c);
            conn.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public static boolean eliminar(int idContacto) {
        SqlSession conn = null;
        try {
            conn = MyBatisUtils.getSession();
            conn.delete("Contacto.eliminar", idContacto);
            conn.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }
}
