package com.poc.calculator.helper;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FormatterTest {

	@InjectMocks
	private Formatter formatter;

	@Test
	@DisplayName("normalize precision result")
	void normalizePrecisionResultTest() {

		assertAll(
				() -> assertEquals("7", Formatter.normalizePrecisionResult(7)),
				() -> assertEquals("7", Formatter.normalizePrecisionResult(7.0)),
				() -> assertEquals("7", Formatter.normalizePrecisionResult(7.00)),
				() -> assertEquals("7", Formatter.normalizePrecisionResult(7.000)),
				() -> assertEquals("7.4", Formatter.normalizePrecisionResult(7.4)),
				() -> assertEquals("-7.45", Formatter.normalizePrecisionResult(-7.45)),
				() -> assertEquals("7.46", Formatter.normalizePrecisionResult(7.458782)),
				() -> assertEquals("-7.46", Formatter.normalizePrecisionResult(-7.458782)),
				() -> assertEquals("4", Formatter.normalizePrecisionResult(4L))
		);
	}
}
