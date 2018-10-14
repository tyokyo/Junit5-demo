package com.example.listener;


import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;


public class CustomTestExecutionListener extends SummaryGeneratingListener{

	@Override
	public void dynamicTestRegistered(TestIdentifier testIdentifier) {
		// TODO Auto-generated method stub
		super.dynamicTestRegistered(testIdentifier);
	}

	@Override
	public void executionFinished(TestIdentifier testIdentifier,
			TestExecutionResult testExecutionResult) {
		System.out.println("executionFinished"+testIdentifier.getUniqueId()+"-"+testExecutionResult.getThrowable().toString());
		// TODO Auto-generated method stub
		super.executionFinished(testIdentifier, testExecutionResult);
	}

	@Override
	public void executionSkipped(TestIdentifier testIdentifier, String reason) {
		// TODO Auto-generated method stub
		super.executionSkipped(testIdentifier, reason);
	}

	@Override
	public void executionStarted(TestIdentifier testIdentifier) {
		System.err.println("executionStarted with uniqueId  =  {"+testIdentifier.getUniqueId()+"--"+testIdentifier.getDisplayName()+"}");
		// TODO Auto-generated method stub
		super.executionStarted(testIdentifier);
	}

	@Override
	public TestExecutionSummary getSummary() {
		// TODO Auto-generated method stub
		System.out.println("=="+getSummary());
		return super.getSummary();
	}

	@Override
	public void testPlanExecutionFinished(TestPlan testPlan) {
		// TODO Auto-generated method stub
		System.out.println("=testPlanExecutionFinished=");
		super.testPlanExecutionFinished(testPlan);
	}

	@Override
	public void testPlanExecutionStarted(TestPlan testPlan) {
		// TODO Auto-generated method stub
		super.testPlanExecutionStarted(testPlan);
	}
	
}
