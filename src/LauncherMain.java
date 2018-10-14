import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

import java.util.Set;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherConfig;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import com.example.listener.CustomTestExecutionListener;
import com.example.mytests.Calculator;
import com.example.mytests.RepeatedTestsDemo;
public class LauncherMain {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
				.selectors(
						selectPackage("com.example.mytests"),
						selectClass(RepeatedTestsDemo.class)
						//selectClass(Class.forName("com.example.mytests.CalculatorTests"))
						)
						.filters(
								includeClassNamePatterns(".*Tests")
								)
								.build();

		Launcher launcher = (Launcher) LauncherFactory.create();

		TestPlan testPlan = launcher.discover(request);
		Set<TestIdentifier> roots = testPlan.getRoots();
		for (TestIdentifier testIdentifier : roots) {
			System.out.println("id is ="+testIdentifier.getUniqueId());
		}
		System.out.println("------------------------------------------");
		// Register a listener of your choice
		TestExecutionListener listener = new CustomTestExecutionListener();
		launcher.registerTestExecutionListeners(listener);
		launcher.execute(request);
	}

}
