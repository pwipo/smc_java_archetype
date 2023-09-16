package ${groupId}.module;

import ru.smcsystem.api.exceptions.ModuleException;
import ru.smcsystem.api.module.Module;
import ru.smcsystem.api.tools.ConfigurationTool;
import ru.smcsystem.api.tools.execution.ExecutionContextTool;

public class Hello implements Module {

    @Override
    public void start(ConfigurationTool configurationTool) throws ModuleException {
    }

    @Override
    public void update(ConfigurationTool configurationTool) throws ModuleException {
        stop(configurationTool);
        start(configurationTool);
    }

    @Override
    public void process(ConfigurationTool configurationTool, ExecutionContextTool executionContextTool) throws ModuleException {
        executionContextTool.addMessage("Hello world");
    }

    @Override
    public void stop(ConfigurationTool configurationTool) throws ModuleException {
    }

}
