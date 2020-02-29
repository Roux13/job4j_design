package ru.job4j.tdd;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleGeneratorTest {

    @Test
    public void whenTakeTextFromDataIsJohnShouldReplaceParamsWithData() throws MoreKeysThanParametersException, NoKeysInMapException {
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}.";
        String[] data = {"John"};
        String expected = "Hello, John.";

        String actual = template.generate(text, data);

        assertThat(actual, is(expected));
    }

    @Test
    public void whenTakeTextFromDataIsAnnaShouldReplaceParamsWithData() throws MoreKeysThanParametersException, NoKeysInMapException {
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}.";
        String[] data = {"Anna"};
        String expected = "Hello, Anna.";

        String actual = template.generate(text, data);

        assertThat(actual, is(expected));
    }

    @Test(expected = NullPointerException.class)
    public void whenTakeTextFromDataIsNullShouldReplaceParamsWithData() throws MoreKeysThanParametersException, NoKeysInMapException {
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}.";
        String[] data = {null};

        template.generate(text, data);
    }

    @Test
    public void whenTemplateHasTwoDifferentParamsThenShouldReplaceAllParamsWithDiffValues() throws MoreKeysThanParametersException, NoKeysInMapException {
        Template template = new SimpleGenerator();
        String text = "I am a ${name}, Who are ${subject}?";
        String[] data = {"John", "you"};
        String expected = "I am a John, Who are you?";

        String actual = template.generate(text, data);

        assertThat(actual, is(expected));
    }

    @Test(expected = NoKeysInMapException.class)
    public void whenDataHasNoParamsThenThrowsNoKeysInMapException() throws MoreKeysThanParametersException, NoKeysInMapException {
        Template template = new SimpleGenerator();
        String text = "I am a John, Who are you?";
        String[] data = {"John", "you"};

        template.generate(text, data);
    }

    @Test(expected = MoreKeysThanParametersException.class)
    public void whenDataHasMoreParamsThenThrowsMoreKeysThenParametersException() throws MoreKeysThanParametersException, NoKeysInMapException {
        Template template = new SimpleGenerator();
        String text = "I am a ${name}, Who are ${subject}?";
        String[] data = {"John", "you", "more"};

        template.generate(text, data);
    }

    @Test
    public void whenTemplateHasTheSameParamsShouldReplaceParamWithTheSameValue() throws MoreKeysThanParametersException, NoKeysInMapException {
        Template template = new SimpleGenerator();
        String text = "Help, ${sos}, ${sos}, ${sos}";
        String[] data = {"Aaaa"};
        String expected = "Help, Aaaa, Aaaa, Aaaa";

        String actual = template.generate(text, data);

        assertThat(actual, is(expected));
    }
}