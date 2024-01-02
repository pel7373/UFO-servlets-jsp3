package ufo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ufo.answers.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static ufo.Constants.*;

public class AcceptChallengeServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            AcceptChallengeServiceTest.class);
    AcceptChallengeService acceptChallengeService = new AcceptChallengeService();
    @Test
    public void callTestTrue() {
        Answer answer = acceptChallengeService.call(true);
        Answer expectedAnswer = new Answer(ACCEPT_CHALLENGE_ACCEPTED, ACCEPT_CHALLENGE_NEXT_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        LOGGER.info("callTestTrue was done");
    }
    @Test
    public void callTestFalse() {
        Answer answer = acceptChallengeService.call(false);
        Answer expectedAnswer = new Answer(ACCEPT_CHALLENGE_NOT_ACCEPTED, LOSE_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        LOGGER.info("callTestFalse was done");
    }
    @Test
    public void callTestAny() {
        String otherAnswer = "aaa11122";
        Answer answer = acceptChallengeService.call(Boolean.parseBoolean(otherAnswer));
        Answer expectedAnswer = new Answer(ACCEPT_CHALLENGE_NOT_ACCEPTED, LOSE_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        LOGGER.info("callTestAny was done");
    }
}