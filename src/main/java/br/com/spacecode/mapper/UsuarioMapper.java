package br.com.spacecode.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import br.com.spacecode.dto.AdicionarUsuarioDTO;
import br.com.spacecode.dto.AtualizarBancaDTO;
import br.com.spacecode.dto.UsuarioDTO;
import br.com.spacecode.model.Banca;
import br.com.spacecode.model.Usuario;

@Mapper(componentModel = "cdi")
public interface UsuarioMapper {
	
	@Mapping(target = "nome", source = "nome")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "dataAtualizacao", ignore = true)
    @Mapping(target = "banca.id", ignore = true)	
    public Usuario toBanca(AdicionarUsuarioDTO dto);
	
	@Mapping(target = "nome", source = "nome")
    public void toRestaurante(AtualizarBancaDTO dto, @MappingTarget Banca banca);

    @Mapping(target = "nome", source = "nome")
    
    @Mapping(target = "dataCriacao", dateFormat = "dd/MM/yyyy HH:mm:ss")
    public UsuarioDTO toRestauranteDTO(Usuario u);

}
