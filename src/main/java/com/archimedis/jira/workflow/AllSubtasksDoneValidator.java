package com.archimedis.jira.workflow;

import com.atlassian.jira.issue.Issue;
import com.opensymphony.workflow.Validator;
import com.opensymphony.workflow.WorkflowException;
import com.opensymphony.module.propertyset.PropertySet;

import org.apache.log4j.Logger;
import java.util.Map;

public class AllSubtasksDoneValidator implements Validator {
    private static final Logger log = Logger.getLogger(AllSubtasksDoneValidator.class);

    @Override
    public void validate(Map transientVars, Map args, PropertySet ps) throws WorkflowException {
        Issue parentIssue = (Issue) transientVars.get("issue");

        // Check if issue has subtasks
        if (parentIssue.getSubTaskObjects().isEmpty()) {
            throw new WorkflowException("This issue has no subtasks.");
        }

        // Check if all subtasks are in "Done" status
        for (Issue subtask : parentIssue.getSubTaskObjects()) {
            if (!"Done".equals(subtask.getStatus().getName())) {
                log.info("Subtask not in Done status: " + subtask.getKey());
                throw new WorkflowException("All subtasks must be done before proceeding to next transition.");
            }
        }
    }
}
