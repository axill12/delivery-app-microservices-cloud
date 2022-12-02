package gr.aueb.mscis.softeng.team6.delivery.service;

import gr.aueb.mscis.softeng.team6.delivery.domain.Area;
import gr.aueb.mscis.softeng.team6.delivery.domain.Product;
import gr.aueb.mscis.softeng.team6.delivery.domain.Store;
import java.util.List;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

/**
 * Service that handles stores.
 *
 * @since 0.1.0
 * @version 1.0.0
 */
@RequestScoped
public class StoreService extends BaseService {
  /**
   * Register a new store.
   *
   * @param name the name of the store.
   * @param type the type of the store.
   * @param areas the areas served by the store.
   * @param products the products offered by the store.
   * @return a new {@link Store} object or {@code null} on error.
   */
  @Transactional
  public Store registerStore(String name, String type, Set<Area> areas, List<Product> products) {
    return persistObject(
        new Store().setName(name).setType(type).setProducts(products).setAreas(areas));
  }
}
