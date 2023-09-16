package ${groupId}.module;

import org.junit.Assert;
import org.junit.Test;
import ru.smcsystem.api.dto.IMessage;
import ru.smcsystem.api.enumeration.ValueType;
import ru.smcsystem.test.Process;
import ru.smcsystem.test.emulate.ConfigurationToolImpl;
import ru.smcsystem.test.emulate.ExecutionContextToolImpl;

import java.util.List;
import java.util.stream.Collectors;

public class HelloTest {

    @Test
    public void process() {
        Process process = new Process(
                new ConfigurationToolImpl(
                        "test",
                        null,
                        null,
                        null,
                        null
                ),
                new Hello()
        );
        ExecutionContextToolImpl executionContextTool = new ExecutionContextToolImpl(null, null, null);
        process.fullLifeCycle(executionContextTool);
        // executionContextTool.getOutput().forEach(m -> System.out.println(m.getMessageType() + " " + m.getValue()));

        List<IMessage> findMessages = executionContextTool.getOutput().stream()
                .filter(m -> ValueType.STRING.equals(m.getType()) && ((String) m.getValue()).equals("Hello world"))
                .collect(Collectors.toList());

        Assert.assertEquals(findMessages.size(), 2);
    }
}
