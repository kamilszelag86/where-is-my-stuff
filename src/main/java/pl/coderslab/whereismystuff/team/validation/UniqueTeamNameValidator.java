package pl.coderslab.whereismystuff.team.validation;

import lombok.RequiredArgsConstructor;
import pl.coderslab.whereismystuff.team.service.TeamService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueTeamNameValidator implements ConstraintValidator<UniqueTeamName, String> {

    private final TeamService teamService;

    @Override
    public void initialize(UniqueTeamName constraint) {
    }

    @Override
    public boolean isValid(String teamName, ConstraintValidatorContext context) {
        return teamService.findByName(teamName) == null;
    }

}
