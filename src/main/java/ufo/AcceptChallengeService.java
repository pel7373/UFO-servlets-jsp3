package ufo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ufo.answers.Answer;

import static ufo.Constants.*;

public class AcceptChallengeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            AcceptChallengeService.class);

    public Answer getAnswer(boolean isAccepted) {
        StringBuilder infoForLogger = new StringBuilder();
        Answer answer;

        infoForLogger.append("Answer was received: ")
                .append(isAccepted)
                .append("; message: ");

        if (isAccepted) {
            answer = new Answer(ACCEPT_CHALLENGE_ACCEPTED, ACCEPT_CHALLENGE_NEXT_PAGE);
            infoForLogger.append(ACCEPT_CHALLENGE_ACCEPTED)
                    .append("; next page: ")
                    .append(ACCEPT_CHALLENGE_NEXT_PAGE);
        } else {
            answer = new Answer(ACCEPT_CHALLENGE_NOT_ACCEPTED, LOSE_PAGE);
            infoForLogger.append(ACCEPT_CHALLENGE_NOT_ACCEPTED)
                    .append("; next page: ")
                    .append(LOSE_PAGE);
        }
        LOGGER.info(infoForLogger.toString());
        return answer;
    }
}