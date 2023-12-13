package ufo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ufo.answers.UFOAnswer;

import static org.junit.jupiter.api.Assertions.*;
import static ufo.AppContent.*;
import static ufo.AppContent.LOSE_PAGE;

class UFO01CaptainBridgeServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(
            UFO01CaptainBridgeServiceTest.class);
    UFO01CaptainBridgeService uFO01CaptainBridgeService = new UFO01CaptainBridgeService();
    @Test
    public void callTestTrue() {
        UFOAnswer answer = uFO01CaptainBridgeService.call(true);
        UFOAnswer expectedAnswer = new UFOAnswer(STEP_1_ACCEPTED, NEXT_1_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        logger.info("callTestTrue was done");
    }
    @Test
    public void callTestFalse() {
        UFOAnswer answer = uFO01CaptainBridgeService.call(false);
        UFOAnswer expectedAnswer = new UFOAnswer(STEP_1_NOT_ACCEPTED, LOSE_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        logger.info("callTestFalse was done");
    }
    @Test
    public void callTestAny() {
        String otherAnswer = "aaa11122";
        UFOAnswer answer = uFO01CaptainBridgeService.call(Boolean.parseBoolean(otherAnswer));
        UFOAnswer expectedAnswer = new UFOAnswer(STEP_1_NOT_ACCEPTED, LOSE_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        logger.info("callTestFalse was done");
    }
}