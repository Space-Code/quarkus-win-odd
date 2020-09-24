package br.com.spacecode.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.spacecode.model.Banca;
import br.com.spacecode.model.WinOuWin;

@ApplicationScoped
public class WinOuWinService {
	
	public List<WinOuWin> findAll() {
		return WinOuWin.findAll().list();
	}

	public WinOuWin findById(Long id) {
		return WinOuWin.findById(id);
	}

	public Response save(WinOuWin win) {
		win.persist();
		return Response.status(201).build();
	}

	public WinOuWin update(Long id, WinOuWin win) {
		WinOuWin winEntidade = Banca.findById(id);

		if (winEntidade == null) {
			throw new WebApplicationException("Esse " + id + " não existe.", Response.Status.NOT_FOUND);
		}

		winEntidade.setTag(win.getTag());
		winEntidade.setTotalInvestido(win.getTotalInvestido());

		return winEntidade;
	}

	public Response delete(Long id) {
		WinOuWin win = WinOuWin.findById(id);
		win.delete();
		return Response.status(201).build();
	}
}