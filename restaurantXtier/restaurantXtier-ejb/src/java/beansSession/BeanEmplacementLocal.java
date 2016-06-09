package beansSession;

import beanEntite.Emplacement;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BeanEmplacementLocal {

    public List<Emplacement> selectAllEmplacement();

    public Emplacement selectEmplacementById(Long id);

    public List<Emplacement> selectEmplPourComEnCours();

    public void updateEmplacement(Emplacement emp);

    public Emplacement selectEmplacementByNumero(String numero);

}
