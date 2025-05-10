package br.com.fiap.gestao.service;

import br.com.fiap.gestao.dto.ResiduoDTO;
import br.com.fiap.gestao.model.Residuo;
import br.com.fiap.gestao.repository.ResiduoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResiduoService {

    @Autowired
    private ResiduoRepository residuoRepository;

    @Transactional(readOnly = true)
    public List<ResiduoDTO> listarTudo() {
        List<Residuo> residuos = residuoRepository.findAll();
        return residuos.stream()
                .map(ResiduoDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ResiduoDTO buscarPorId(Long idResiduo) {
        return new ResiduoDTO(residuoRepository.getReferenceById(idResiduo));
    }

    @Transactional
    public ResiduoDTO criar(ResiduoDTO dto) {
        Residuo residuo = new Residuo();
        residuo.setTipo(dto.getTipo());
        residuo.setDescricao(dto.getDescricao());
        return new ResiduoDTO(residuoRepository.save(residuo));
    }

    @Transactional
    public ResiduoDTO atualizar(Long idResiduo, ResiduoDTO dto) {
        Residuo residuo = residuoRepository.getReferenceById(idResiduo);
        residuo.setTipo(dto.getTipo());
        residuo.setDescricao(dto.getDescricao());
        return new ResiduoDTO(residuoRepository.save(residuo));
    }

    @Transactional
    public void deletar(Long idResiduo) {
        residuoRepository.deleteById(idResiduo);
    }
}
