package com.archimedis.jira.workflow;

import com.atlassian.jira.plugin.workflow.AbstractWorkflowPluginFactory;
import com.atlassian.jira.plugin.workflow.WorkflowPluginValidatorFactory;
import com.opensymphony.workflow.loader.AbstractDescriptor;

import java.util.Map;

public class AllSubtasksDoneValidatorFactory extends AbstractWorkflowPluginFactory implements WorkflowPluginValidatorFactory {
    @Override
    public Map<String, Object> getDescriptorParams(Map<String, Object> validatorParams) {
        return validatorParams;
    }   

    @Override
    protected void getVelocityParamsForInput(Map<String, Object> velocityParams) {
    }

    @Override
    protected void getVelocityParamsForEdit(Map<String, Object> velocityParams, AbstractDescriptor descriptor) {
    }

    @Override
    protected void getVelocityParamsForView(Map<String, Object> velocityParams, AbstractDescriptor descriptor) {
    }
}
