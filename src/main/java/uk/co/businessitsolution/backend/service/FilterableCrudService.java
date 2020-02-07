package uk.co.businessitsolution.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uk.co.businessitsolution.backend.entity.AbstractEntity;

import java.util.Optional;

public interface FilterableCrudService<T extends AbstractEntity> extends CrudService<T> {

	Page<T> findAnyMatching(Optional<String> filter, Pageable pageable);

	long countAnyMatching(Optional<String> filter);

}
