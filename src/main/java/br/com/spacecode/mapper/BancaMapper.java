package br.com.spacecode.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import br.com.spacecode.dto.AdicionarBancaDTO;
import br.com.spacecode.dto.AtualizarBancaDTO;
import br.com.spacecode.model.Banca;

@Mapper(componentModel = "cdi")
public interface BancaMapper {
	
	@Mapping(target = "valorBanca", source = "valorBanca")
    public Banca toBanca(AdicionarBancaDTO dto);
	
	@Mapping(target = "valorBanca", source = "valorBanca")
    public void toBanca(AtualizarBancaDTO dto, @MappingTarget Banca banca);

}
