package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Turma;
import br.com.senac.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repo;
	
	public List<Turma> buscarTodasTurmas() {
		return repo.findAll();
	}
	
	public Turma salvar(Turma turma) {
		return repo.save(turma);
	}
	
	public Turma buscarPorId(Integer id) {
		String resposta = "Turma não encontrada.";
		Optional<Turma> turma = repo.findById(id);
		return turma.orElseThrow(() -> new ObjectNotFoundException(1L,resposta));
	}
	
	public void deletarPorId(Integer id) {
		repo.deleteById(id);
	}
	
	public Turma salvarAlteracao(Turma turmaAlterada) {
		Turma turma = buscarPorId(turmaAlterada.getId());
		turma.setTurno(turmaAlterada.getTurno());
		return salvar(turma);
	}
}
