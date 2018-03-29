package co.simplon.filrouge.tool;


import co.simplon.filrouge.modele.PoliceCase;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;


import java.util.ArrayList;
import java.util.List;

public class PoliceCaseSpecificationsBuilder {

    private final List<SearchCriteria> params;



    public PoliceCaseSpecificationsBuilder() {
        params = new ArrayList<>();
    }

    public PoliceCaseSpecificationsBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<PoliceCase> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification<PoliceCase>> specs = new ArrayList<>();
        for (SearchCriteria param : params) {
            specs.add(new PoliceCaseSpecification(param));
        }

        Specification<PoliceCase> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) result = Specifications.where(result).and(specs.get(i));

        return result;
    }
}
