/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Paciente;
import br.com.beans.ProfissionalDeSaude;
import br.com.beans.Prontuario;
import br.com.model.daos.ProntuarioDAO;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public class ProntuarioBusiness implements IProntuarioBusiness{

    private ProntuarioDAO prontuarioDAO;
    IpacienteBusiness ipacienteBusiness;
    IFuncionarioBusiness funcionarioBusiness;
    
    public ProntuarioBusiness(IpacienteBusiness pacienteBusiness, IFuncionarioBusiness iFuncionarioBusiness) {
        prontuarioDAO = new ProntuarioDAO();
        this.ipacienteBusiness = pacienteBusiness;
        this.funcionarioBusiness = iFuncionarioBusiness;
    }

    @Override
    public boolean salvarProntuario(Paciente paciente, ProfissionalDeSaude profissionalDeSaude, EntityManagerFactory emf) throws Exception {
        String codigo_Medico_pacienteNovaRelacao ="";
        String  codigo_Medico_paciente="";
        int tamanhoApelido = profissionalDeSaude.getApelido().length();
        Prontuario novoProntuario=null;
        boolean novaRelacao=true;
        GregorianCalendar dataDeAbertura = new GregorianCalendar();
        
        for (Prontuario proontuario : paciente.getProntuarios()) {
           if(profissionalDeSaude.getApelido().equals(proontuario.getCodigo_Medico_Paciente().substring(0, tamanhoApelido))){
                  codigo_Medico_paciente = proontuario.getCodigo_Medico_Paciente();
                  novaRelacao=false;
           }
        }
        if(novaRelacao){  
        codigo_Medico_pacienteNovaRelacao = profissionalDeSaude.getApelido();
        profissionalDeSaude.setQuantidadePacientes(profissionalDeSaude.getQuantidadePacientes()+1);
        funcionarioBusiness.atualizarProfissionalDeSaude(profissionalDeSaude, emf);
        codigo_Medico_pacienteNovaRelacao += profissionalDeSaude.getQuantidadePacientes();
        novoProntuario = new Prontuario();
        novoProntuario.setDataAbertura(dataDeAbertura);
        novoProntuario.setCodigo_Medico_Paciente(codigo_Medico_pacienteNovaRelacao);
        prontuarioDAO.persist(novoProntuario, emf);
        List<Prontuario> p = paciente.getProntuarios();
        p.add(novoProntuario);
        paciente.setProntuarios(p);
        ipacienteBusiness.atualizarPaciente(paciente, emf);
        return true;
        } else{       
        novoProntuario = new Prontuario();
        novoProntuario.setCodigo_Medico_Paciente(codigo_Medico_paciente);
        novoProntuario.setDataAbertura(dataDeAbertura);
        prontuarioDAO.persist(novoProntuario, emf);
        List<Prontuario> p = paciente.getProntuarios();
        p.add(novoProntuario);
        paciente.setProntuarios(p);
        ipacienteBusiness.atualizarPaciente(paciente, emf);
            return true;
        }
      
    }

    @Override
    public boolean removerProntuario(Prontuario prontuario, EntityManagerFactory emf) throws Exception {
        
        if(prontuarioDAO.remove(prontuario, emf)){
         return true;
        }
        
        return false;
    }

    @Override
    public Prontuario atualizarProntuario(Prontuario prontuario, EntityManagerFactory emf) throws Exception {
       if(prontuarioDAO.merge(prontuario, emf)){
        return prontuario;
       }
       return null;
    }
  
    
}
