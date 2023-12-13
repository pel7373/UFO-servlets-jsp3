package ufo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ufo.answers.UFOAnswer;

import static org.junit.jupiter.api.Assertions.*;
import static ufo.AppContent.*;
import static ufo.AppContent.LOSE_PAGE;

class UFO02WhoAreYouServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(
            UFO02WhoAreYouServiceTest.class);
    UFO02WhoAreYouService uFO02WhoAreYouService = new UFO02WhoAreYouService();
    @Test
    public void callTestTrue() {
        UFOAnswer answer = uFO02WhoAreYouService.call(true);
        UFOAnswer expectedAnswer = new UFOAnswer(STEP_2_ACCEPTED, NEXT_2_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        logger.info("callTestTrue was done");
    }
    @Test
    public void callTestFalse() {
        UFOAnswer answer = uFO02WhoAreYouService.call(false);
        UFOAnswer expectedAnswer = new UFOAnswer(STEP_2_NOT_ACCEPTED, LOSE_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        logger.info("callTestFalse was done");
    }
    @Test
    public void callTestAny() {
        String otherAnswer = "aaa11122";
        UFOAnswer answer = uFO02WhoAreYouService.call(Boolean.parseBoolean(otherAnswer));
        UFOAnswer expectedAnswer = new UFOAnswer(STEP_2_NOT_ACCEPTED, LOSE_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        logger.info("callTestFalse was done");
    }
}