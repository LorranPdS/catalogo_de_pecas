package catalogo.api.zensa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import catalogo.api.zensa.model.Produto;
import catalogo.api.zensa.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("/cadastroproduto")
	public ModelAndView inicio() {
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroproduto");
		Iterable<Produto> prodCadastrados = produtoRepository.findAll(PageRequest.of(0, 10, Sort.by("nomePeca")));
		modelAndView.addObject("objetoProduto", new Produto());		
		modelAndView.addObject("produtos", prodCadastrados);
		
		return modelAndView;
	}
	
	@GetMapping("/produtospag")
	public ModelAndView carregarProdPaginacao(@PageableDefault(size = 10, sort = {"nomePeca"})
	Pageable pageable, ModelAndView modelAndView) {
		Page<Produto> pageProduto = produtoRepository.findAll(pageable);
		modelAndView.addObject("produtos", pageProduto);
		modelAndView.addObject("objetoProduto", new Produto());
		modelAndView.setViewName("cadastro/cadastroproduto");
		
		return modelAndView;
	}
	
	@PostMapping("**/salvarproduto")
	public ModelAndView cadastrarProduto(Produto produto) {
		produtoRepository.save(produto);
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroproduto");
		Iterable<Produto> prodCadastrados = produtoRepository.findAll(PageRequest.of(0, 10, Sort.by("nomePeca")));
		modelAndView.addObject("produtos", prodCadastrados);
		modelAndView.addObject("objetoProduto", new Produto());
		modelAndView.addObject("msg", "CADASTRADO COM SUCESSO!");
		
		return modelAndView;
	}
	
	@GetMapping("/excluirProduto/{idproduto}")
	public ModelAndView excluirProduto(@PathVariable("idproduto") Long idproduto) {
		produtoRepository.deleteById(idproduto);
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroproduto");
		modelAndView.addObject("produtos", produtoRepository.findAll(PageRequest.of(0, 10, Sort.by("nomePeca"))));
		modelAndView.addObject("objetoProduto", new Produto());
		modelAndView.addObject("msg", "REMOVIDO COM SUCESSO!");
		
		return modelAndView;
	}
}