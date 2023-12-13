package ufo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ufo.answers.UFOAnswer;

import static ufo.AppContent.*;

public class UFO00AcceptChallengeService {
    private static final Logger logger = LoggerFactory.getLogger(
            UFO00AcceptChallengeService.class);

    public UFOAnswer call(boolean isAccepted) {
        StringBuilder sb = new StringBuilder();
        sb.append("Answer was received. isAccepted: ")
                .append(isAccepted)
                .append("; message: ");

        UFOAnswer answer;
        if (isAccepted) {
            answer = new UFOAnswer(STEP_0_ACCEPTED, NEXT_0_PAGE);
            sb.append(STEP_0_ACCEPTED)
                    .append("; next page: ")
                    .append(NEXT_0_PAGE);
        } else {
            answer = new UFOAnswer(STEP_0_NOT_ACCEPTED, LOSE_PAGE);
            sb.append(STEP_0_NOT_ACCEPTED)
                    .append("; next page: ")
                    .append(LOSE_PAGE);
        }
        logger.info(sb.toString());
        return answer;
    }
}