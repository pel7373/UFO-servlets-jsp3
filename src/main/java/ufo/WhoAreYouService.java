package ufo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ufo.answers.Answer;

import static ufo.Constants.*;

public class WhoAreYouService {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            WhoAreYouService.class);

    public Answer getAnswer(boolean isAccepted) {
        StringBuilder infoForLogger = new StringBuilder();
        Answer answer;

        infoForLogger.append("Answer was received: ")
                .append(isAccepted)
                .append("; message: ");

        if (isAccepted) {
            answer = new Answer(WHO_ARE_YOU_ACCEPTED, WHO_ARE_YOU_NEXT_PAGE);
            infoForLogger.append(WHO_ARE_YOU_ACCEPTED)
                    .append("; next page: ")
                    .append(WHO_ARE_YOU_NEXT_PAGE);
        } else {
            answer = new Answer(WHO_ARE_YOU_NOT_ACCEPTED, LOSE_PAGE);
            infoForLogger.append(WHO_ARE_YOU_NOT_ACCEPTED)
                    .append("; next page: ")
                    .append(LOSE_PAGE);
        }
        LOGGER.info(infoForLogger.toString());
        return answer;
    }
}
