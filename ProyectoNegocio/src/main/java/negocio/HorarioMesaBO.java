/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import conexion.Conexion;
import conexion.IConexion;
import dao.HorarioMesaDAO;
import entidadesJPA.HorarioMesa;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IHorarioMesaBO;
import interfaces.IHorarioMesaDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pauli
 */
public class HorarioMesaBO implements IHorarioMesaBO {
     private final IConexion conexion;
     private IHorarioMesaDAO horarioMesaDao;

    public HorarioMesaBO() {
        this.conexion = new Conexion();
        this.horarioMesaDao = new HorarioMesaDAO(conexion);
    }
    
    public void crearHorarioMesa(HorarioMesa horarioMesa)throws NegocioException{
        
        this.horarioMesaDao.crearHorarioMesa(horarioMesa);
    }
    public List<HorarioMesa> obtenerHorariosPorMesa(Long idMesa){
         try {
             return this.horarioMesaDao.obtenerHorariosPorMesa(idMesa);
         } catch (PersistenciaException ex) {
             Logger.getLogger(HorarioMesaBO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }
    
    
     
     
}
