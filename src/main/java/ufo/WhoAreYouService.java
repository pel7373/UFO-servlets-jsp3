package ufo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ufo.answers.Answer;

import static ufo.Constants.*;

public class WhoAreYouService {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            WhoAreYouService.class);

    public Answer call(boolean isAccepted) {
        StringBuilder sb = new StringBuilder();
        Answer answer;

        sb.append("Answer was received: ")
                .append(isAccepted)
                .append("; message: ");

        if (isAccepted) {
            answer = new Answer(WHO_ARE_YOU_ACCEPTED, WHO_ARE_YOU_NEXT_PAGE);
            sb.append(WHO_ARE_YOU_ACCEPTED)
                    .append("; next page: ")
                    .append(WHO_ARE_YOU_NEXT_PAGE);
        } else {
            answer = new Answer(WHO_ARE_YOU_NOT_ACCEPTED, LOSE_PAGE);
            sb.append(WHO_ARE_YOU_NOT_ACCEPTED)
                    .append("; next page: ")
                    .append(LOSE_PAGE);
        }
        LOGGER.info(sb.toString());
        return answer;
    }
}
