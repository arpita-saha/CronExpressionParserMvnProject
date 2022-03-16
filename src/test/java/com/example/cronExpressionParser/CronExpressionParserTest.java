package com.example.cronExpressionParser;

import com.example.cronExpressionParser.model.CronExpression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CronExpressionParserTest {
    CronExpressionParser cronExpressionParser;

    @BeforeEach
    public void setUp() {
        cronExpressionParser = CronExpressionParser.getInstance();
    }

    @Test
    public void getCronExpression_whenValidInput_shouldReturnCronExpressionObject() {
        String expression = "1/15 0 1,15 * 1-5 /usr/bin/find";
        CronExpression cronExpression = cronExpressionParser.getCronExpression(expression);
        assert cronExpression.getCommand().equals("/usr/bin/find");
        Assertions.assertEquals(0, cronExpression.getHours().get(0));
    }

	@Test
	public void getCronExpression_whenInvalidWeekDayInput_shouldReturnCronExpressionObject() {
		String expression = "1/15 0 * 1-5 /usr/bin/find";
		CronExpression cronExpression = cronExpressionParser.getCronExpression(expression);
		Assertions.assertNull(cronExpression);
	}

    @Test
    public void getCronExpression_whenUnsupportedDayInput_shouldReturnCronExpressionObject() {
		String expression = "1/15 0 1,##15 * 1-5 /usr/bin/find";
        CronExpression cronExpression = cronExpressionParser.getCronExpression(expression);
        Assertions.assertNull(cronExpression);
    }

	@Test
	public void getCronExpression_whenUnsupportedHourInput_shouldReturnCronExpressionObject() {
		String expression = "1/15 % 1,15 * 1-5 /usr/bin/find";
		CronExpression cronExpression = cronExpressionParser.getCronExpression(expression);
		Assertions.assertNull(cronExpression);
	}
	@Test
	public void getCronExpression_whenUnsupportedMinuteInput_shouldReturnCronExpressionObject() {
		String expression = "1/#15 0 1,15 * 1-5 /usr/bin/find";
		CronExpression cronExpression = cronExpressionParser.getCronExpression(expression);
		Assertions.assertNull(cronExpression);
	}
	@Test
	public void getCronExpression_whenUnsupportedMonthInput_shouldReturnCronExpressionObject() {
		String expression = "1/15 0 1,15 # 1-5 /usr/bin/find";
		CronExpression cronExpression = cronExpressionParser.getCronExpression(expression);
		Assertions.assertNull(cronExpression);
	}
	@Test
	public void getCronExpression_whenUnsupportedWeekDayInput_shouldReturnCronExpressionObject() {
		String expression = "1/15 0 1,15 * 1-&5 /usr/bin/find";
		CronExpression cronExpression = cronExpressionParser.getCronExpression(expression);
		Assertions.assertNull(cronExpression);
	}

}
