package co.simplon.filrouge.controleur;

import co.simplon.filrouge.modele.People;
import co.simplon.filrouge.modele.PoliceCase;
import co.simplon.filrouge.repository.PeopleRepository;
import co.simplon.filrouge.repository.PoliceCaseRepository;
import co.simplon.filrouge.tool.PeopleSpecificationsBuilder;
import co.simplon.filrouge.tool.PoliceCaseSpecificationsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class SearchControleur {


        @Autowired
        private PoliceCaseRepository repo;

        @RequestMapping(method = RequestMethod.GET, value = "/case")
        @ResponseBody
        public List<PoliceCase> search(@RequestParam(value = "search") String search) {
            PoliceCaseSpecificationsBuilder builder = new PoliceCaseSpecificationsBuilder();
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
            }

            Specification<PoliceCase> spec = builder.build();
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println(repo.findAll(spec));
            return repo.findAll(spec);
        }

    @Autowired
    private PeopleRepository repo2;

    @RequestMapping(method = RequestMethod.GET, value = "/people")
    @ResponseBody
    public List<People> search2(@RequestParam(value = "search") String search2) {
        PeopleSpecificationsBuilder builder = new PeopleSpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search2 + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }

        Specification<People> spec2 = builder.build();
        return repo2.findAll(spec2);
    }
  }

