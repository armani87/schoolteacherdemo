package org.wecancodeit.schoolteacherdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wecancodeit.schoolteacherdemo.models.School;
import org.wecancodeit.schoolteacherdemo.models.Subject;
import org.wecancodeit.schoolteacherdemo.models.Teacher;
import org.wecancodeit.schoolteacherdemo.repositories.SchoolRepository;
import org.wecancodeit.schoolteacherdemo.repositories.SubjectRepository;
import org.wecancodeit.schoolteacherdemo.repositories.TeacherRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SchoolRepository schoolRepo;
    @Autowired
    private TeacherRepository teacherRepo;
    @Autowired
    private SubjectRepository subjectRepo;




    @Test
    public void schoolShouldHaveAListOfSubjects(){
        School testSchool = new School("Test Location");
        School testSchool2 = new School("Test Location");
        Teacher testTeacher1 = new Teacher("Test firstName", "Test lastName");
        Subject testSubject1 = new Subject("Title", "Description", testSchool, testTeacher1);
        Subject testSubject2 = new Subject("Title", "Description", testSchool2, testTeacher1);

        schoolRepo.save(testSchool);
        schoolRepo.save(testSchool2);
        teacherRepo.save(testTeacher1);
        subjectRepo.save(testSubject1);
        subjectRepo.save(testSubject2);

        entityManager.flush();
        entityManager.clear();

        Optional<School> retrievedSchoolOpt = schoolRepo.findById(testSchool.getId());
        School retrievedSchool = retrievedSchoolOpt.get();
        Subject retrievedSubject = subjectRepo.findById(testSubject1.getId()).get();
        assertThat(retrievedSchool.getSubjects()).contains(testSubject1);
    }

    @Test
    public void subjectsShouldBeAbleToHaveMultipleTeachers(){
        School testSchool = new School("Test Location");
        Teacher testTeacher1 = new Teacher("Test firstName", "Test lastName");
        Teacher testTeacher2 = new Teacher("Test firstName2", "Test lastName2");
        Subject testSubject1 = new Subject("Title", "Description", testSchool, testTeacher1, testTeacher2);
        Subject testSubject2 = new Subject("Title", "Description", testSchool, testTeacher1);
        Subject testSubject3 = new Subject("Title", "Description", testSchool, testTeacher2);
        schoolRepo.save(testSchool);
        teacherRepo.save(testTeacher1);
        teacherRepo.save(testTeacher2);
        subjectRepo.save(testSubject1);
        subjectRepo.save(testSubject2);
        subjectRepo.save(testSubject3);

        entityManager.flush();
        entityManager.clear();

        Subject retrievedSubject = subjectRepo.findById(testSubject1.getId()).get();
        Teacher retrievedTeacher1 = teacherRepo.findById(testTeacher1.getId()).get();
        Teacher retrievedTeacher2 = teacherRepo.findById(testTeacher2.getId()).get();
        assertThat(retrievedSubject.getTeachers()).contains(testTeacher1,testTeacher2);
    }




}
