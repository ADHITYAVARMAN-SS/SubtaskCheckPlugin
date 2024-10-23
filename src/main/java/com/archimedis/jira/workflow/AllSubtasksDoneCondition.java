package com.archimedis.jira.workflow;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.workflow.condition.AbstractJiraCondition;
import org.apache.log4j.Logger;
import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.WorkflowException;
import java.util.Map;

public class AllSubtasksDoneCondition extends AbstractJiraCondition {

    
    private static final Logger log = Logger.getLogger(AllSubtasksDoneCondition.class);

    @Override
    public boolean passesCondition(Map transientVars, Map args, PropertySet ps) throws WorkflowException {
        Issue parentIssue = getIssue(transientVars);

        // Check if issue has subtasks
        if (parentIssue.getSubTaskObjects().isEmpty()) {
            return false;
        }
        // Check if all subtasks are in "Done" status
        for (Issue subtask : parentIssue.getSubTaskObjects()) {
            if (!"Done".equals(subtask.getStatus().getName())) {
                log.info("Subtask not in Done status: " + subtask.getKey());
                return true;
            }
        }
        return false;
    }
}
