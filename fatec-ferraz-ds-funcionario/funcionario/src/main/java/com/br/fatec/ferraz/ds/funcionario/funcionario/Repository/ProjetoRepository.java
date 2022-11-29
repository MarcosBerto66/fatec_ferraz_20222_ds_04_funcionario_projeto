package com.br.fatec.ferraz.ds.funcionario.funcionario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fatec.ferraz.ds.funcionario.funcionario.Model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{
    
}
