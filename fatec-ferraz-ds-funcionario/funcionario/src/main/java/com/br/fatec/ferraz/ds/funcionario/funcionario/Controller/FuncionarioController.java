package com.br.fatec.ferraz.ds.funcionario.funcionario.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import com.br.fatec.ferraz.ds.funcionario.funcionario.Repository.FuncionarioRepository;

import java.util.List;
import java.util.Optional;

import com.br.fatec.ferraz.ds.funcionario.funcionario.Model.Funcionario;

@RestController
@RequestMapping("/api/funcionario")
@AllArgsConstructor
public class FuncionarioController {
    
    private FuncionarioRepository funcionarioRepository; 

    @GetMapping
    public List<Funcionario> list() {
        return funcionarioRepository.findAll();
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED) 
    public Funcionario create (@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        funcionarioRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    Optional<Object> update(@RequestBody Funcionario newFuncionario, @PathVariable Long id) {
      
      return funcionarioRepository.findById(id).
        map(funcionario -> {
          funcionario.setNome(newFuncionario.getNome());
          funcionario.setDataEmissao(newFuncionario.getDataEmissao());
          funcionario.setSalario(newFuncionario.getSalario());
          funcionario.setCelular(newFuncionario.getCelular());
          funcionario.setEmail(newFuncionario.getEmail());
          return funcionarioRepository.save(funcionario);
        });
    }

    @GetMapping("/{id}")
    public Optional<Funcionario> getId(@PathVariable Long id) {
      return funcionarioRepository.findById(id);
    }
}
