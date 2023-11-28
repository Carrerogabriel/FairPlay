package com.example.terca.repository;



import com.example.terca.model.UsuarioPermissoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioPermissoesRepository extends JpaRepository<UsuarioPermissoes, Long> {
}
