package com.br.fatec.ferraz.ds.funcionario.funcionario.Model;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

import javax.persistence.JoinColumn;

@Data
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_generator")
    private Long id;

      
    @Column(length = 100, nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    private Date dataEmissao;

    @Column(precision = 10, scale = 2, nullable = false)
    private Double salario;

    @Column(length = 25, nullable = false)
    private String celular;

    @Column(length = 50, nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "funcionario_projeto",
        joinColumns = { @JoinColumn(name = "funcionario_id") },
        inverseJoinColumns = { @JoinColumn(name = "projeto_id") })
    private Set<Projeto> projetos = new HashSet<>(); 
    
}
