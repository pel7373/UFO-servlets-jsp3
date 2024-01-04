package ufo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ufo.answers.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static ufo.Constants.*;
import static ufo.Constants.LOSE_PAGE;

class WhoAreYouServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            WhoAreYouServiceTest.class);
    WhoAreYouService whoAreYouService = new WhoAreYouService();
    @Test
    public void callTestTrue() {
        Answer answer = whoAreYouService.call(true);
        Answer expectedAnswer = new Answer(WHO_ARE_YOU_ACCEPTED, WHO_ARE_YOU_NEXT_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        LOGGER.info("callTestTrue was done");
    }
    @Test
    public void callTestFalse() {
        Answer answer = whoAreYouService.call(false);
        Answer expectedAnswer = new Answer(WHO_ARE_YOU_NOT_ACCEPTED, LOSE_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        LOGGER.info("callTestFalse was done");
    }
    @Test
    public void callTestAny() {
        String otherAnswer = "aaa11122";
        Answer answer = whoAreYouService.call(Boolean.parseBoolean(otherAnswer));
        Answer expectedAnswer = new Answer(WHO_ARE_YOU_NOT_ACCEPTED, LOSE_PAGE);
        assertEquals(expectedAnswer.getMessage(), answer.getMessage());
        assertEquals(expectedAnswer.getPage(), answer.getPage());
        LOGGER.info("callTestAny was done");
    }
}