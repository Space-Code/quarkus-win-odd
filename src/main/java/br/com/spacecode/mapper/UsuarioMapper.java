package br.com.spacecode.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import br.com.spacecode.dto.AdicionarUsuarioDTO;
import br.com.spacecode.dto.AtualizarUsuarioDTO;
import br.com.spacecode.dto.UsuarioDTO;
import br.com.spacecode.model.Usuario;

@Mapper(componentModel = "cdi")
public interface UsuarioMapper {
	
	@Mapping(target = "nome", source = "nome")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "dataAtualizacao", ignore = true)
    @Mapping(target = "banca.id", ignore = true)	
    public Usuario toUsuario(AdicionarUsuarioDTO dto);
	
	@Mapping(target = "nome", source = "nome")
    public void toUsuario(AtualizarUsuarioDTO dto, @MappingTarget Usuario usuario);

    @Mapping(target = "nome", source = "nome")
    
    @Mapping(target = "dataCriacao", dateFormat = "dd/MM/yyyy HH:mm:ss")
    public UsuarioDTO toUsuarioDTO(Usuario u);

}
