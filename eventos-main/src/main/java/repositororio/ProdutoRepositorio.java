package repositororio;

import org.senai.eventos.entity.produto.Produto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
}
