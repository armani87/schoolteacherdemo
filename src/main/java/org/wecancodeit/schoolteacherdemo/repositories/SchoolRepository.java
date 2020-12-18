package org.wecancodeit.schoolteacherdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.schoolteacherdemo.models.School;

public interface SchoolRepository  extends CrudRepository<School, Long> {
    School findSchoolByLocation(String location);


}
