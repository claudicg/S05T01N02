package cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.domain.FlowerEntity;
import jakarta.transaction.Transactional;

@Repository("FlowerRepository")
@Transactional
public interface FlowerRepository extends JpaRepository<FlowerEntity, Integer>{

	 
}
