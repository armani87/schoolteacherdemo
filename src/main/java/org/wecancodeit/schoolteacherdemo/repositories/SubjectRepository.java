package org.wecancodeit.schoolteacherdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.schoolteacherdemo.models.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
}

