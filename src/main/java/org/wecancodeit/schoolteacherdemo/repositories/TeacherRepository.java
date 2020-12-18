package org.wecancodeit.schoolteacherdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.schoolteacherdemo.models.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
