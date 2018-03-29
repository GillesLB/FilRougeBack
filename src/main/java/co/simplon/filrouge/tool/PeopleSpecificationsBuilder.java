package co.simplon.filrouge.tool;


import co.simplon.filrouge.modele.People;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import java.util.ArrayList;
import java.util.List;

public class PeopleSpecificationsBuilder {

    private final List<SearchCriteria> params;



    public PeopleSpecificationsBuilder() {
        params = new ArrayList<>();
    }

    public PeopleSpecificationsBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<People> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification<People>> specs = new ArrayList<>();
        for (SearchCriteria param : params) {
            specs.add(new PeopleSpecification(param));
        }

        Specification<People> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) result = Specifications.where(result).and(specs.get(i));

        return result;
    }
}
