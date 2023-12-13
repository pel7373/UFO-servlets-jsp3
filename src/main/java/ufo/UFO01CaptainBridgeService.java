package ufo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ufo.answers.UFOAnswer;
import ufo.web.UFO00ChallengeServlet;

import static ufo.AppContent.*;

public class UFO01CaptainBridgeService {
    private static final Logger logger = LoggerFactory.getLogger(
            UFO01CaptainBridgeService.class);
    public UFOAnswer call(boolean isAccepted) {
        StringBuilder sb = new StringBuilder();
        UFOAnswer answer;

        sb.append("Answer was received. isAccepted: ")
                .append(isAccepted)
                .append("; message: ");

        if (isAccepted) {
            answer = new UFOAnswer(STEP_1_ACCEPTED, NEXT_1_PAGE);
            sb.append(STEP_1_ACCEPTED)
                    .append("; next page: ")
                    .append(NEXT_1_PAGE);

        } else {
            answer = new UFOAnswer(STEP_1_NOT_ACCEPTED, LOSE_PAGE);
            sb.append(STEP_1_NOT_ACCEPTED)
                    .append("; next page: ")
                    .append(LOSE_PAGE);
        }
        logger.info(sb.toString());
        return answer;
    }
}
