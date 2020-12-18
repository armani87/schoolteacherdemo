package org.wecancodeit.schoolteacherdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.schoolteacherdemo.models.School;
import org.wecancodeit.schoolteacherdemo.models.Subject;
import org.wecancodeit.schoolteacherdemo.models.Teacher;
import org.wecancodeit.schoolteacherdemo.repositories.SchoolRepository;
import org.wecancodeit.schoolteacherdemo.repositories.SubjectRepository;
import org.wecancodeit.schoolteacherdemo.repositories.TeacherRepository;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private SchoolRepository schoolRepo;
    @Resource
    private TeacherRepository teacherRepo;
    @Resource
    private SubjectRepository subjectRepo;


    @Override
    public void run(String...args) throws Exception {

        School columbus = new School("Columbus");
        School cleveland = new School("Cleveland");
        schoolRepo.save(columbus);
        schoolRepo.save(cleveland);

        Teacher campbell = new Teacher("Armand", "Campbell");
        Teacher donald = new Teacher("Scrooge", "Donald");
        Teacher money = new Teacher("Mitch", "Money");
        Teacher payne = new Teacher("Martin", "Payne");
        Teacher randy = new Teacher("Sauvage", "Randy");
        teacherRepo.save(campbell);
        teacherRepo.save(donald);
        teacherRepo.save(money);
        teacherRepo.save(payne);
        teacherRepo.save(randy);

        Subject greatnessFromWithin = new Subject ("The Greatness from within","This class builds self affirmation and confidence techniques", cleveland, campbell, donald, payne);
        Subject theKeyToFinancialFreedom = new Subject ("The Key to Financial Freedom", "This class explains building multiple strands of income",columbus, money, campbell);
        Subject theSilverLining = new Subject ("The Silver Lining","This class gives a unique perspective on how to view positivity and growth in all aspects of life", columbus, donald, payne);
        Subject shapeShiftingStyleBender = new Subject ("Shape Shifting Style Bender","This class focuses on being like water and adapting", cleveland, money,campbell);
        subjectRepo.save(greatnessFromWithin);
        subjectRepo.save(theKeyToFinancialFreedom);
        subjectRepo.save(theSilverLining);
        subjectRepo.save(shapeShiftingStyleBender);
    }

}
