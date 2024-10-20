package com.archimedis.jira.workflow;

import com.atlassian.jira.plugin.workflow.AbstractWorkflowPluginFactory;
import com.atlassian.jira.plugin.workflow.WorkflowPluginConditionFactory;
import com.opensymphony.workflow.loader.AbstractDescriptor; // Required for AbstractDescriptor
import java.util.Map;

public class AllSubtasksDoneConditionFactory extends AbstractWorkflowPluginFactory
        implements WorkflowPluginConditionFactory {
            

    @Override
    public Map<String, Object> getDescriptorParams(Map<String, Object> conditionParams) {
        // Return the conditionParams directly since no extra parameters are needed
        return conditionParams;
    }

    @Override
    protected void getVelocityParamsForInput(Map<String, Object> velocityParams) {
        // No input required for this condition
    }

    @Override
    protected void getVelocityParamsForEdit(Map<String, Object> velocityParams, AbstractDescriptor descriptor) {
        // No input required for this condition
    }

    @Override
    protected void getVelocityParamsForView(Map<String, Object> velocityParams, AbstractDescriptor descriptor) {
        // No input required for this condition
    }
}