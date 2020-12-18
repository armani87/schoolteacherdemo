package org.wecancodeit.schoolteacherdemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.schoolteacherdemo.models.School;
import org.wecancodeit.schoolteacherdemo.models.Subject;
import org.wecancodeit.schoolteacherdemo.models.Teacher;
import org.wecancodeit.schoolteacherdemo.repositories.SchoolRepository;
import org.wecancodeit.schoolteacherdemo.repositories.SubjectRepository;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class WebLayerTest {

    @MockBean
    private SchoolRepository schoolRepo;

    @MockBean
    private SubjectRepository subjectRepo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void schoolsShouldBeOkAndReturnSchoolsViewWithSchoolsModelAttribute() throws Exception{
        mockMvc.perform(get("/schools"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("schoolView"))
                .andExpect(model().attributeExists("schools"));
    }




    @Test
    public void subjectsShouldBeOkAndReturnSubjectsViewWithSubjectsModelAttribute() throws Exception{
        mockMvc.perform(get("/subjects"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("subjectsView"))
                .andExpect(model().attributeExists("subjects"));
    }


    @Test
    public void  teachersShouldBeOkAndReturnATeachersViewWithTeachersModelAttribute() throws Exception{
        mockMvc.perform(get("/teachers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("teachersView"))
                .andExpect(model().attributeExists("teachers"));
    }

    @Test
    public void  shouldBeOkForASingleSchoolEndpointWithSchoolViewAndSchoolModelAttribute() throws Exception{
        School testSchool = new School("Columbus");
        when(schoolRepo.findSchoolByLocation("Columbus")).thenReturn(testSchool);
        mockMvc.perform(get("/schools/Columbus"))
                .andExpect(status().isOk())
                .andExpect(view().name("schoolView"))
                .andExpect(model().attributeExists("school"));
    }

    @Test
    public void shouldBeOkForSingleSubjectViewAndSubjectsViewAndSubjectModelAttribute() throws Exception {
        School testSchool = new School("Columbus");
        Teacher testTeacher = new Teacher("First","Last");
        Subject testSubject = new Subject("Title", "Description", testSchool, testTeacher);
        when(subjectRepo.findById(testSubject.getId()).equals(testSubject));
        mockMvc.perform(get("/subjects/{testSubject.getId()}"))
                .andExpect(status().isOk())
                .andExpect(view().name("subjectView"))
                .andExpect(model().attributeExists("subject"));



    }
}