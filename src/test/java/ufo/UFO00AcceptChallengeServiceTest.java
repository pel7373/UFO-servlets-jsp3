package ufo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ufo.answers.UFOAnswer;

import static org.junit.jupiter.api.Assertions.*;
import static ufo.AppContent.*;

public class UFO00AcceptChallengeServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(
            UFO00AcceptChallengeServiceTest.class);
    UFO00AcceptChallengeService uFO00AcceptChallengeService = new UFO00AcceptChallengeService();
    @Test
    public void callTestTrue() {
        UFOAnswer answer = uFO00AcceptChallengeService.call(true);
        UFOAnswer expectedAnswer = new UFOAnswer(STEP_0_ACCEPTED, NEXT_0_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        logger.info("callTestTrue was done");
    }
    @Test
    public void callTestFalse() {
        UFOAnswer answer = uFO00AcceptChallengeService.call(false);
        UFOAnswer expectedAnswer = new UFOAnswer(STEP_0_NOT_ACCEPTED, LOSE_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        logger.info("callTestFalse was done");
    }
    @Test
    public void callTestAny() {
        String otherAnswer = "aaa11122";
        UFOAnswer answer = uFO00AcceptChallengeService.call(Boolean.parseBoolean(otherAnswer));
        UFOAnswer expectedAnswer = new UFOAnswer(STEP_0_NOT_ACCEPTED, LOSE_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        logger.info("callTestAny was done");
    }
}