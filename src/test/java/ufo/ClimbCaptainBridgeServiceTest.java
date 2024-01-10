package ufo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ufo.answers.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static ufo.Constants.*;
import static ufo.Constants.LOSE_PAGE;

class ClimbCaptainBridgeServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            ClimbCaptainBridgeServiceTest.class);
    ClimbCaptainBridgeService climbCaptainBridgeService = new ClimbCaptainBridgeService();
    @Test
    public void callTestTrue() {
        Answer answer = climbCaptainBridgeService.getAnswer(true);
        Answer expectedAnswer = new Answer(CLIMB_CAPTAIN_BRIDGE_ACCEPTED, CLIMB_CAPTAIN_BRIDGE_NEXT_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        LOGGER.info("callTestTrue was done");
    }
    @Test
    public void callTestFalse() {
        Answer answer = climbCaptainBridgeService.getAnswer(false);
        Answer expectedAnswer = new Answer(CLIMB_CAPTAIN_BRIDGE_NOT_ACCEPTED, LOSE_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        LOGGER.info("callTestFalse was done");
    }
    @Test
    public void callTestAny() {
        String otherAnswer = "aaa11122";
        Answer answer = climbCaptainBridgeService.getAnswer(Boolean.parseBoolean(otherAnswer));
        Answer expectedAnswer = new Answer(CLIMB_CAPTAIN_BRIDGE_NOT_ACCEPTED, LOSE_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        LOGGER.info("callTestAny was done");
    }
}