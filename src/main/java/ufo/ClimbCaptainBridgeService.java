package ufo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ufo.answers.Answer;

import static ufo.Constants.*;

public class ClimbCaptainBridgeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            ClimbCaptainBridgeService.class);

    public Answer getAnswer(boolean isAccepted) {
        StringBuilder infoForLogger = new StringBuilder();
        Answer answer;

        infoForLogger.append("Answer was received: ")
                .append(isAccepted)
                .append("; message: ");

        if (isAccepted) {
            answer = new Answer(CLIMB_CAPTAIN_BRIDGE_ACCEPTED, CLIMB_CAPTAIN_BRIDGE_NEXT_PAGE);
            infoForLogger.append(CLIMB_CAPTAIN_BRIDGE_ACCEPTED)
                    .append("; next page: ")
                    .append(CLIMB_CAPTAIN_BRIDGE_NEXT_PAGE);

        } else {
            answer = new Answer(CLIMB_CAPTAIN_BRIDGE_NOT_ACCEPTED, LOSE_PAGE);
            infoForLogger.append(CLIMB_CAPTAIN_BRIDGE_NOT_ACCEPTED)
                    .append("; next page: ")
                    .append(LOSE_PAGE);
        }
        LOGGER.info(infoForLogger.toString());
        return answer;
    }
}
